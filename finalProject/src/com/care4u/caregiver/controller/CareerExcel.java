package com.care4u.caregiver.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.care4u.caregiver.vo.CareerVO;
import com.care4u.caregiver.vo.ContractVO;

//excelView 뷰를 찾으면, 이것을 현재클래스 ExcelBuilder 가
//AbstratcExcelView를 상속했기 때문에 이것은 뷰이다.
//DispatcherServlet -> [View]jsp (model) : forward
//@SuppressWarnings("deprecation")
public class CareerExcel extends AbstractExcelView{
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			//HSSF - 마이크로 소프트의 엑셀 전용 클래스
			//DispatcherServlet 에 의해서 Model을 받습니다.
			//${listBooks}
			//List<ShowVO> listShow = (List<ShowVO>) model.get("listShow");
			ContractVO conlist = (ContractVO) model.get("conlist");
			//poi문법
			//sheet를 생성
			HSSFSheet sheet = workbook.createSheet("Career List");
			sheet.setDefaultColumnWidth(30);
			CellStyle style = workbook.createCellStyle();
			Font font = workbook.createFont();	
			font.setFontName("Arial");
			style.setFillForegroundColor(HSSFColor.BLUE.index);
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			font.setColor(HSSFColor.WHITE.index);
			style.setFont(font);
			HSSFRow header = sheet.createRow(0);
			//엑셀의 셀 타이틀
			String[] str = {"경력번호","계약번호","근무지역","근무기간","근무상태"};
			for(int i=0; i< str.length; i++) {
				header.createCell(i).setCellValue(str[i]);
				header.getCell(i).setCellStyle(style);
			}
			int rowCount = 1;
			//셀의 내용을 채움
			for( CareerVO e : conlist.getCalist()) {
				HSSFRow aRow = sheet.createRow(rowCount++);
				aRow.createCell(0).setCellValue(e.getCano());
				aRow.createCell(1).setCellValue(e.getConno());
				aRow.createCell(2).setCellValue(conlist.getConaddr1());
				aRow.createCell(3).setCellValue(conlist.getConstartdate() + "~" + conlist.getConenddate());
				//castate에 따른 출력값을 달리해줌
				if (e.getCastate().equals("N")) {
					e.setCastate("근무중");
				} else if (e.getCastate().equals("Y")) {
					e.setCastate("근무종료");
				}
				aRow.createCell(4).setCellValue(e.getCastate());
	}
			//응답객체로 부터 다운로드 받을 타입과 파일 이름을 설정한다.
			response.setContentType("Application/Msexcel");
			response.setHeader("Content-Disposition", "attachment; filename=career_list.xls;");
	}
}