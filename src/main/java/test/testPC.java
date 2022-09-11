package test;

import datos.PcDAO;
import domain.PC;

import java.util.List;

public class testPC {

    public static void main(String[] args) {

        PcDAO pcdao = new PcDAO();

        //----GET----
        List<PC> pcS = pcdao.Seleccionar();

//        for (PC pc:pcS){
//
//            System.out.println("pcdao = " + pcdao);
//
//        }

        //----POST----
//        PC insertarPc = new PC("core 64", "999999GB", "intel");
//
//        pcdao.Registro(insertarPc);


        //----DELETE----
//        PC deletePc = new PC(2);
//
//        pcdao.Delete(deletePc);


        //----PUT----
        PC actualizarPc = new PC(3,"core i7", "64GB", "GEFORCE 940MX");
        pcdao.Update(actualizarPc);


    }

}
