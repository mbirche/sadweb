/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import br.edu.sadweb.modelos.Aluno;
import br.edu.sadweb.modelos.Pessoa;
import br.edu.sadweb.modelos.Telefone;
import br.edu.sadweb.modelos.Usuario;
import br.edu.sadweb.persistencia.BDSession;
import br.edu.sadweb.persistencia.BDTransaction;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Birche
 */
public class Main {
    public static void main(String[] args) {
        
        Pessoa ps = new Pessoa();
        Aluno a = new Aluno();
        Aluno b;
        Telefone t1 = new Telefone();
        Telefone t2 = new Telefone();
        Usuario usr1 = new Usuario();
        Usuario usr2 = new Usuario();
        List<Pessoa> lista;
        
        //Teste relacionamento usuario
        usr1.setLogin("alis");
        usr1.setSenha("111");
        usr2.setLogin("princesa");
        usr2.setSenha("222");
        
        HashSet<Usuario> usrs = new HashSet<Usuario>();
        usrs.add(usr1);
        usrs.add(usr2);
        a.setUsuarios(usrs);
        
        //Teste relacionamento telefone
        t1.setNumero("97571-2401");
        t2.setNumero("4699-1148");
        ArrayList<Telefone> tel = new ArrayList<Telefone>();
        tel.add(t1);
        tel.add(t2);
        a.setTelefones(tel);
        
        //Teste Relacionamento herança
        a.setNome("Alis");
        a.setSobrenome("Henrique Ferri");
        a.setRa("092321-5");
        
        System.out.println("Passei aki!");
        
        Session session = BDSession.getSession();
        Transaction tx = BDTransaction.getTransaction(session);
                       
        session.save(a);
        
        Criteria cri = session.createCriteria(Pessoa.class);
        
        cri.add(Restrictions.like("sobrenome", "%enri%"));
        cri.add(Restrictions.like("sobrenome", "%err%"));
        
        lista = cri.list();
        Set<Pessoa> listaSet = new HashSet<Pessoa>();
        
        Iterator ite = lista.iterator();
        
        while(ite.hasNext()){
            listaSet.add((Pessoa)ite.next());
        }
            
        
        Iterator iter = listaSet.iterator();
        while (iter.hasNext()) {
            System.out.println(((Pessoa) iter.next()).getId());
        }

        
        b = (Aluno) session.get(Aluno.class, 1050);
        
        Iterator it = b.getUsuarios().iterator();
        
        System.out.println(b.getNome());
        System.out.println(b.getRa());
        System.out.println(b.getTelefones().get(0).getNumero());
        System.out.println(b.getTelefones().get(1).getNumero());
        while(it.hasNext()){
            System.out.println(((Usuario)it.next()).getLogin());
        }
        System.out.println(listaSet.size());
        
        tx.commit();
        session.close();

    }
}
