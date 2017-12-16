package servlet.paketi;

import hibernate.paketi.*;
import org.json.simple.parser.ParseException;
import web.servis.paketi.AylikSicaklikWebServisimizIcinClient;
import web.servis.paketi.ClientWebService;
import web.servis.paketi.HavaDurumuWebServisimizIcinClient;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/ControllerServlet")
public class ControllerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        /*
        Eğerki veritabanımıza bulk datayı parse edip tekrar eklemek istersek burayı çalıştıracağız

            BulkAylikSicaklikVeritabaninaEkleWebService.bulkDatayiVeritabaninaEkle();
            BulkHavaDurumuVeritabaninaEkleWebService.bulkDatayiVeritabaninaEkle();

         */
        String theCommand=request.getParameter("command");
        if(theCommand.equals("ONLINE"))
        {
            webServistenDirekGoster(request,response);

        }
        else if(theCommand.equals("OFFLINE"))
        {
            veritabaniServisindenHavaDurumuGoster(request,response);
        }
        else if(theCommand.equals("AYLIK"))
        {
            veritabaniServisindenAylikSicaklikGoster(request,response);
        }




    }

    private void veritabaniServisindenAylikSicaklikGoster(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AylikYillikSicaklik aylikYillikSicaklik=null;
        String sehirAdi=request.getParameter("sehir");
        try {
            aylikYillikSicaklik= AylikSicaklikWebServisimizIcinClient.bizimWebServistenVeriCek(sehirAdi);
        } catch (ParseException e)
        {
            e.printStackTrace();
        }

        request.setAttribute("sicaklikVerisi",aylikYillikSicaklik);
        RequestDispatcher rd=request.getRequestDispatcher("/offlineAylikSicaklik.jsp");
        rd.forward(request,response);
    }


    private void webServistenDirekGoster(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
    {

        HavaDurumu havaDurumuObjemiz=null;
        String sehirAdi=request.getParameter("sehir");

        //Web Service den veriyi çekiyoruz try catch içinde
        try {
            havaDurumuObjemiz= ClientWebService.webServistenVeriCek(sehirAdi);
        } catch (ParseException e)
        {
            e.printStackTrace();
        }


        request.setAttribute("havaDurumuObjesi",havaDurumuObjemiz);
        RequestDispatcher rd=request.getRequestDispatcher("/onlineHavaDurumu.jsp");
        rd.forward(request,response);

    }

    private void veritabaniServisindenHavaDurumuGoster(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String sehirAdi=request.getParameter("sehir");
        List<HavaDurumu> havaDurumuList=null;

        try
        {
            havaDurumuList=new ArrayList<>();
            havaDurumuList= HavaDurumuWebServisimizIcinClient.bizimWebServistenVeriCek(sehirAdi);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        request.setAttribute("havaDurumuListesi",havaDurumuList);
        RequestDispatcher rd=request.getRequestDispatcher("/offlineHavaDurumu.jsp");
        rd.forward(request,response);



    }






}
