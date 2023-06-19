

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "TuDienThucHanhServlet", value = "/TuDienThucHanhServlet")
public class TuDienThucHanhServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> dictionary = new HashMap<>();

        dictionary.put("hello","Xin chào");
        dictionary.put("how","Thế nào");
        dictionary.put("book","Quyển vở");
        dictionary.put("computer","Máy tính");
        String search = request.getParameter("textSearch");
        String result=null;
        for (String s:dictionary.keySet()) {
            if (s.equals(search)){
                result=dictionary.get(s);
            }
        }
        if (result==null){
            result="Khong tim thay";
        }
        request.setAttribute("result",result);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
