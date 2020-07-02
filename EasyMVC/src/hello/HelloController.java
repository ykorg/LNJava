package hello;

import com.yk.easymvc.annotation.Controller;
import com.yk.easymvc.annotation.RequestMapping;
import com.yk.easymvc.bean.ModelAndView;

/*
 	目的: 在地址栏输入 : http://localhost:80/hello
 	就去执行HelloController 类中 的sayHello 方法
 	跳转到WEB-INF/views/welcome.jsp页面,并在改页面
 	获取共享数据 ${msg}
  
 * */
//表示当前类是一个请求处理器
@Controller
public class HelloController {
	
	//给访问sayHello方法设置一个请求URL
	@RequestMapping("/hello")
	// 封装了模型(共享数据) 和视图(跳转界面)
	public ModelAndView sayHello() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("welcome");
		
		mv.addAttribute("msg","你好 easyMVC");
		
		return mv;
	}
	
	//扫描使用的类,判断哪些类使用了Controller 注解,如果
}
