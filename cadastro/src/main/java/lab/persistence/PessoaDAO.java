package lab.persistence;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import lab.entity.Pessoa;
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

	public List<Pessoa> find2(String filter) {
		StringBuffer jpql = new StringBuffer();
		jpql.append(" select p ");
		jpql.append("   from Pessoa p ");
		jpql.append("  where lower(p.nome) like :filter ");
		jpql.append("     or lower(p.email) like :filter ");
		jpql.append("     or p.telefone like :filter ");
		jpql.append("  order by ");
		jpql.append("        p.nome asc ");

		TypedQuery<Pessoa> query = em.createQuery(jpql.toString(), Pessoa.class);
		query.setParameter("filter", "%" + (filter == null ? "" : filter.toLowerCase()) + "%");

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
