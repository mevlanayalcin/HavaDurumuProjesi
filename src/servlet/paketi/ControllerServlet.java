package servlet.paketi;

import hibernate.paketi.*;
import org.json.simple.parser.ParseException;
import web.servis.paketi.ClientWebService;
import web.servis.paketi.KendiWebServisimizIcinClient;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/ControllerServlet")
public class ControllerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        servistenVeriCek(request,response);
        jspVeriGonder(request,response);


    }

    private void jspVeriGonder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sehirAdi=request.getParameter("sehir");
        HavaDurumu havaDurumu=null;

        try
        {
            havaDurumu= KendiWebServisimizIcinClient.bizimWebServistenVeriCek(sehirAdi);
        } catch (ParseException e)
        {
            e.printStackTrace();
        }

        System.out.println(havaDurumu);
        request.setAttribute("havaDurumuObjesi",havaDurumu);
        RequestDispatcher rd=request.getRequestDispatcher("/yonlenen.jsp");
        rd.forward(request,response);

    }




    private void servistenVeriCek(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
    {
        Boolean donus=false;
        HavaDurumu havaDurumuObjemiz=null;
        String sehirAdi=request.getParameter("sehir");
        donus= DatabaseVeriKontrol.databasedeMevcutmu(sehirAdi);

        //Web Service den veriyi çekiyoruz try catch içinde
        try {
            havaDurumuObjemiz= ClientWebService.webServistenVeriCek(sehirAdi);
        } catch (ParseException e)
        {
            e.printStackTrace();
        }


        if(donus==true)
        {
            DatabaseVeriUpdate.databaseUpdate(havaDurumuObjemiz);
        }
        if(donus==false)
        {
            DatabaseVeriEkle.databaseVeriEkle(havaDurumuObjemiz);
        }


    }


}
