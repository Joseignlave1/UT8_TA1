package com.mycompany.mavenproject1;
import java.lang.reflect.Array;
import java.util.*;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido {
protected TAristas lasAristas = new TAristas() ;
       /**
     *
     * @param vertices
     * @param aristas
     */
    public TGrafoNoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
       super(vertices, aristas);     
      lasAristas.insertarAmbosSentidos(aristas);
       
    }

    @Override
    public boolean insertarArista(TArista arista) {
        boolean tempbool = false;
        TArista arInv = new TArista(arista.getEtiquetaDestino(), arista.getEtiquetaOrigen(), arista.getCosto());
        tempbool = (super.insertarArista(arista) && super.insertarArista(arInv));
        return tempbool;
    }
public TAristas getLasAristas() {
        return lasAristas;
    }
 

 
    @Override
    public TGrafoNoDirigido Prim() {
        ArrayList<TVertice> u = new ArrayList<>();
        ArrayList<TVertice> v = new ArrayList<>(this.getVertices());
        ArrayList<TVertice> t = new ArrayList<>();
        TAristas a = new TAristas();
        // Agrega un vértice arbitrario a u para iniciar
        u.add(v.get(0));
        v.remove(0);
        while(!v.isEmpty()) {
            TArista aristaMin = a.buscarMin(u,v);
            u.add(aristaMin.getEtiquetaDestino());
            v.remove(aristaMin.getEtiquetaDestino());
            t.add(aristaMin);
        }
        return t;

    }

    @Override
    public TGrafoNoDirigido Kruskal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
