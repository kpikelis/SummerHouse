/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import DbEntities.SummerHouses;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author kpikelis
 */
@Stateless
public class SummerHousesFacade extends AbstractFacade<SummerHouses> {

    @PersistenceContext(unitName = "SummerHousePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SummerHousesFacade() {
        super(SummerHouses.class);
    }
    
}
