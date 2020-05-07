package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/firstone")
public class FrowFilter implements Filter {

 
    public FrowFilter() {
    	System.out.println("FlowFilter 객체 생성");
    }


	public void destroy() {
		System.out.println("FlowFilter 객체 삭제");
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("서블릿 수행 전...");
		chain.doFilter(request, response);
		System.out.println("서블릿 수행 후...");
	}


	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("FlowFilter 객체 초기화");
	}

}
