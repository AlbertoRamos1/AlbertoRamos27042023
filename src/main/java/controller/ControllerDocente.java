package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Docente;

public class ControllerDocente {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AlbertoRamos27042023");

	public static List<Docente> findByName(String nombre){
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM profesoresymaterias.docente where lower(nombreCompleto) like '" + nombre.toLowerCase() + "'", Docente.class);
		List<Docente> lista = (List<Docente>)q.getResultList();
		em.close();
		return lista;
	}
	
}
