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

//excelView �並 ã����, �̰��� ����Ŭ���� ExcelBuilder ��
//AbstratcExcelView�� ����߱� ������ �̰��� ���̴�.
//DispatcherServlet -> [View]jsp (model) : forward
//@SuppressWarnings("deprecation")
public class CareerExcel extends AbstractExcelView{
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			//HSSF - ����ũ�� ����Ʈ�� ���� ���� Ŭ����
			//DispatcherServlet �� ���ؼ� Model�� �޽��ϴ�.
			//${listBooks}
			//List<ShowVO> listShow = (List<ShowVO>) model.get("listShow");
			ContractVO conlist = (ContractVO) model.get("conlist");
			//poi����
			//sheet�� ����
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
			//������ �� Ÿ��Ʋ
			String[] str = {"��¹�ȣ","����ȣ","�ٹ�����","�ٹ��Ⱓ","�ٹ�����"};
			for(int i=0; i< str.length; i++) {
				header.createCell(i).setCellValue(str[i]);
				header.getCell(i).setCellStyle(style);
			}
			int rowCount = 1;
			//���� ������ ä��
			for( CareerVO e : conlist.getCalist()) {
				HSSFRow aRow = sheet.createRow(rowCount++);
				aRow.createCell(0).setCellValue(e.getCano());
				aRow.createCell(1).setCellValue(e.getConno());
				aRow.createCell(2).setCellValue(conlist.getConaddr1());
				aRow.createCell(3).setCellValue(conlist.getConstartdate() + "~" + conlist.getConenddate());
				//castate�� ���� ��°��� �޸�����
				if (e.getCastate().equals("N")) {
					e.setCastate("�ٹ���");
				} else if (e.getCastate().equals("Y")) {
					e.setCastate("�ٹ�����");
				}
				aRow.createCell(4).setCellValue(e.getCastate());
	}
			//���䰴ü�� ���� �ٿ�ε� ���� Ÿ�԰� ���� �̸��� �����Ѵ�.
			response.setContentType("Application/Msexcel");
			response.setHeader("Content-Disposition", "attachment; filename=career_list.xls;");
	}
}