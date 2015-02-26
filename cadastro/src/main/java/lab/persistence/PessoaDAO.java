package lab.persistence;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import lab.entity.Pessoa;
import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Beans;

@Transactional
public class PessoaDAO {

	@Inject
	private EntityManager em;

	public static PessoaDAO getInstance() {
		return Beans.getReference(PessoaDAO.class);
	}

	public List<Pessoa> find() {
		StringBuffer jpql = new StringBuffer();
		jpql.append(" select p ");
		jpql.append("   from Pessoa p ");
		jpql.append("  order by ");
		jpql.append("        p.nome asc ");

		TypedQuery<Pessoa> query = em.createQuery(jpql.toString(), Pessoa.class);

		return query.getResultList();
	}

	public void insert(Pessoa pessoa) {
		em.persist(pessoa);
	}

	public void update(Pessoa pessoa) {
		em.merge(pessoa);
	}

	public Pessoa load(Integer id) {
		return em.find(Pessoa.class, id);
	}
}
