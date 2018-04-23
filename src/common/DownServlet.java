package common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/common/down")
public class DownServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		//	�뙆�씪�씠 ���옣�맂 寃쎈줈
		String filePath = request.getParameter("filePath");
		// �떎�젣 ���옣�맂 �뙆�씪紐�
		String sName = request.getParameter("sName");
		// �떎�슫濡쒕뱶 �븷 �뙆�씪紐�
		String dName = request.getParameter("dName");
		
		String flag = "gallary";
		if(request.getParameter("flag")!=null) {
			flag = request.getParameter("flag");
		}
		
		File f = new File("c:/mini-home/upload" + filePath);	

		if (flag.equals("gallary")) {
			 f = new File("c:/mini-home/upload" + filePath, sName);		
		}
		

		if (dName == null) {
			// dName �뙆�씪誘명꽣媛� �뾾�쓣�븣
			// 利� �떎�슫濡쒕뱶 �븞諛쏄퀬 �떢�쓣�븣
			response.setHeader(
					"Content-Type",
					"image/jpg"
			);
			
		}else {
			// �떎�슫濡쒕뱶
			
			
			// 釉뚮씪�슦��媛� 異쒕젰留먭퀬 �떎�슫濡쒕뱶 �븷 �닔 �엳�룄濡� �븳�떎
			
			// �뿤�뜑 媛믪쓣 蹂�寃쏀빐以��떎. 
			// �떎�슫濡쒕뱶 �븷 �븣 �궗�슜�븯�뒗 而⑦뀗�듃 ���엯
			response.setHeader(
					"Content-Type",
					"application/octet-stream"
			);
			// �썝 �뙆�씪紐낆씠 �븳湲��씪 寃쎌슦 �씤肄붾뵫
			// 8859_1 諛⑹떇�쑝濡� 臾몄옄�뿴�쓣 議고빀�빐�씪
			dName = new String(
					dName.getBytes("utf-8"), "8859_1");
			
			// �떎�슫濡쒕뱶�떆 �뙆�씪紐� 吏��젙
			// �떎�슫濡쒕뱶�떆 �뙆�씪�쓣 吏��젙�븯�뒗 ���엯
			response.setHeader(
					"Content-Disposition", 
					"attachment;filename=" + dName
			);
			// 蹂대궡�뒗 �뜲�씠�꽣�뒗 諛붿씠�꼫由� �씤肄붾뵫 �엫�쓣 �븣�젮以��떎.
			response.setHeader(
					"Content-Transfer-Encoding", 
					"binary"
			);	
			// 釉뚮씪�슦���뿉寃� �궡媛� 蹂대궡�뒗 嫄곗쓽 湲몄씠瑜� �븣�젮以��떎

			response.setHeader(
					"Content-Length", 
					String.valueOf(f.length())
			);
				 // �떎瑜� �뜲�씠�꽣 ���엯�쓣 �뒪�듃留곸쑝濡�
			// -------------------------------------------------------------
		}
		FileInputStream fis = new FileInputStream(f);
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		OutputStream out = response.getOutputStream(); // �뙆�씪�씠�땲源� write �븯硫� �븞�맖
		BufferedOutputStream bos = new BufferedOutputStream(out);
		while (true) {
			int ch = bis.read();
			if (ch == -1) break;
			
			bos.write(ch); //�궗�슜�옄�뿉寃� 異쒕젰
		}
		
		bis.close();
		fis.close();

		bos.close();
		out.close();
	}
	
}