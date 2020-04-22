package maksym.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class FilterPermission implements Filter {

    private boolean active = false;

    @Override
    public void init(FilterConfig config) {
        String act = config.getInitParameter("active");
        if (act != null) {
            active = (act.equalsIgnoreCase("TRUE"));
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (active) {
            if (!(request instanceof HttpServletRequest &&
                    response instanceof HttpServletResponse)) {
                throw new ServletException("non-HTTP request or response");
            }
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;

            HttpSession session = httpServletRequest.getSession();
            String forwardPage;
            if (session == null || session.getAttribute("user") == null) {
                httpServletResponse.sendRedirect("Profile");
                return;
            }
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}
