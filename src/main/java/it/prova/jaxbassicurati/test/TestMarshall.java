//package it.prova.jaxbassicurati.test;
//
//import it.prova.jaxbassicurati.flusso.marshall.Assicurati;
//
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.Marshaller;
//
//public class TestMarshall {
//
//
//    static Assicurati assicurati = new Assicurati();
//
//    static {
//
////        <nome>Giovanni</nome>
////        <cognome>Gemini</cognome>
////        <datanascita>1996-02-01</datanascita>
////        <nuovisinistri>15</nuovisinistri>
////        <codicefiscale>GMNGNN96B01H501D</codicefiscale>
//
//
//        Assicurati.Assicurato ass1 = new Assicurati.Assicurato();
//
//        ass1.setNome("gino");
//        ass1.setCognome("bula");
//        ass1.setDatanascita("1900-02-01");
//        ass1.setNuovisinistri((byte) 11);
//
//
//
//        //Add the employees in list
//        employees.getEmployees().add(emp1);
//
//    }
//
//    public static void main(String[] args) {
//        JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
//        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//
//        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//        //Marshal the employees list in console
//        jaxbMarshaller.marshal(employees, System.out);
//
//        //Marshal the employees list in file
//        jaxbMarshaller.marshal(employees, new File("c:/temp/employees.xml"));
//    }
//}
