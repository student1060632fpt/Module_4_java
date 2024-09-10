package controllers;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	@ModelAttribute
	public void fontChu(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping(path = {"/","/home","/home.htm"})
	public String home() {
		return "home";			//--> viewResolver :  prefix + view name + suffix --> "/WEB-INF/views/" + "home" + ".jsp" --> /WEB-INF/views/home.jsp
	}
	@RequestMapping(path = "/setCookie")
	@ResponseBody
	public String setCookie(HttpServletResponse response) {
		//mình  mún lấy cookie nào thì lấy tên giá trị, xong gấn cái cần trả lời
		Cookie cook1 = new Cookie("tenDV", "Trung_tam_tin_hoc");
		cook1.setMaxAge(3600*24*30);//tính bằng giây
		response.addCookie(cook1);
		return "đã thiết lập cookie";
	}
	
	//lấy cookie
	@RequestMapping(path = "/getCookie")
	@ResponseBody
	public String getCookie(HttpServletRequest request) {
		//mình  mún lấy cookie nào thì lấy tên giá trị, xong gấn cái cần trả lời
		Cookie[] mangCookie = request.getCookies();//khi tự động mở server nó tự động gửi lên, gửi lên cũng ko báo, gửi xún cũng ko báo, nhưng mà nó chắc chắn nằm trong đối tượng request này
		String s = "";
		for(Cookie ck:mangCookie) {
			if(ck.getName().equals("tenDV"))
				s+= ck.getName()+" - "+ ck.getValue()+"\n";				
		}
		return s;
	}
	
	//lấy cookie theo tên cookie only
		@RequestMapping(path = "/getCookieValue")
		@ResponseBody
		public String getCookie(@CookieValue(name="tenDV") String tenDV) {
			//mình  mún lấy cookie nào thì lấy tên giá trị, xong gấn cái cần trả lời
			
			return tenDV;
		}
}
