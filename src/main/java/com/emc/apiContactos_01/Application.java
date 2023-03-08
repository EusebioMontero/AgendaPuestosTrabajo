package com.emc.apiContactos_01;

import com.emc.apiContactos_01.entities.*;
import com.emc.apiContactos_01.repositories.*;
import com.emc.apiContactos_01.util.Turno;
import org.aspectj.lang.annotation.Before;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Application.class, args);
        ContactosRepository contactosRepository = context.getBean(ContactosRepository.class);
        DepartamentosRepository departamentosRepository = context.getBean(DepartamentosRepository.class);
        SeccionesRepository seccionesRepository = context.getBean(SeccionesRepository.class);
        ZonasRepository zonasRepository = context.getBean(ZonasRepository.class);
        AreaAsignadaRepository areaAsignadaRepository = context.getBean(AreaAsignadaRepository.class);
        SedesRepository sedesRepository = context.getBean(SedesRepository.class);
        PuestosRepository puestosRepository = context.getBean(PuestosRepository.class);

        Puesto puestoBadajozCapital = new Puesto("OIS Sede Badajoz Capital", Turno.Mañana, false);
        Puesto puestoBadajozMerida = new Puesto("OIS Sede Mérida", Turno.Mañana, true);
        Puesto puestoBadajozPueblos = new Puesto("OIS Sede Pueblos", Turno.Mañana, true);
        List<Puesto> puestoList = List.of(puestoBadajozPueblos, puestoBadajozCapital, puestoBadajozMerida);

        Contacto jesus = new Contacto("Jesus", "Trenado", "Nosé", "mail", "tel_1", "tel_2", puestoBadajozCapital, Turno.Mañana);
        Contacto eusebio = new Contacto("Eusebio", "Montero", "Camacho", "mail", "tel_1", "tel_2", puestoBadajozMerida, Turno.Mañana);
        Contacto noelia = new Contacto("Noelia", "Concepcion", "Centeno", "mail", "tel_1", "tel_2", puestoBadajozPueblos, Turno.Mañana);

        Seccion seccion_1 = new Seccion("OIS");
        Seccion seccion_2 = new Seccion("Especialistas CAP");
        Seccion seccion_3 = new Seccion("Dirección");
        List<Seccion> seccionList = List.of(seccion_1, seccion_2);

        Departamento dept_1 = new Departamento("Proyecto Justicia");
        Departamento dept_2 = new Departamento("Dirección");
        List<Departamento> departamentosList = List.of(dept_1, dept_2);

        AreaAsignada areaBadajoz_1 = new AreaAsignada("Sede de la ciudad de Badajoz");
        AreaAsignada areaBadajoz_2 = new AreaAsignada("Pueblos de Badajoz");
        AreaAsignada areaBadajoz_3 = new AreaAsignada("Sede de Mérida");
        List<AreaAsignada> areaAsignadas = List.of(areaBadajoz_1, areaBadajoz_2, areaBadajoz_3);

        Sede sedeBadajoz = new Sede("Sede de Badajoz Avda. Colón");
        Sede sedeMerida = new Sede("Mérida");
        Sede sedeAlmendralejo = new Sede("Sede Almendralejo");
        Sede sedeBadajozMontijo = new Sede("Sede Montijo");
        Sede sedeOcania = new Sede("Sede Ocaña");
        List<Sede> sedesListExt = List.of(sedeAlmendralejo, sedeBadajozMontijo, sedeMerida, sedeBadajoz);
        List<Sede> sedesListPueblosBadajoz = List.of(sedeAlmendralejo, sedeBadajozMontijo);
        List<Sede> sedesListMad = List.of(sedeOcania);

        Zona zonaExt = new Zona("Extremadura");
        Zona zonaMad = new Zona("Madrid");
        List<Zona> zonasList = List.of(zonaExt, zonaMad);
        zonaExt.getSedes().addAll(sedesListExt);
        zonaMad.getSedes().add(sedeOcania);

        puestoBadajozCapital.getContactos().add(jesus);
        puestoBadajozCapital.setAreaAsignada(areaBadajoz_1);
        puestoBadajozMerida.getContactos().add(eusebio);
        puestoBadajozMerida.setAreaAsignada(areaBadajoz_3);
        puestoBadajozPueblos.setAreaAsignada(areaBadajoz_2);
        puestoBadajozPueblos.getContactos().add(noelia);


        seccion_1.getPuestos().addAll(puestoList);
        seccion_1.getPuestos().add(puestoBadajozMerida);

        dept_1.getSecciones().add(seccion_1);
        dept_1.getSecciones().add(seccion_2);
        dept_2.getSecciones().add(seccion_3);

        areaBadajoz_1.getPuestos().add(puestoBadajozCapital);
        areaBadajoz_1.getSedes().add(sedeBadajoz);
        areaBadajoz_2.getPuestos().add(puestoBadajozPueblos);
        areaBadajoz_2.getSedes().addAll(sedesListPueblosBadajoz);
        areaBadajoz_3.getPuestos().add(puestoBadajozMerida);
        areaBadajoz_3.getSedes().add(sedeMerida);


        zonasRepository.saveAll(zonasList);
        departamentosRepository.saveAll(departamentosList);
        seccionesRepository.saveAll(seccionList);
        areaAsignadaRepository.saveAll(areaAsignadas);
        sedesRepository.saveAll(sedesListExt);
        sedesRepository.saveAll(sedesListMad);
        puestosRepository.saveAll(puestoList);

/*









		sedesRepository.saveAll(sedesList);





//		seccionesRepository.saveAll(seccionList);

//		puestosRepository.findAll().forEach(System.out::println);
		System.out.println("******************************");
		System.out.println(puestosRepository.findByGuardia(true));
		System.out.println(contactosRepository.findByPuestoId(2L));
//		System.out.println(contactosRepository.contactosBySede("Mérida"));
//		System.out.println(contactosRepository.findById(1L));
//		System.out.println(contactosRepository.findById(2L));
//		System.out.println(contactosRepository.findAll());
*/
    }

}
