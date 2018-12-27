package customer.model;

import java.util.List;

import kostaco.model.KostacoVO;

public interface CustomerDAO {

	public int insert(CustomerVO vo);

	public int update(KostacoVO vo);

	public int delete(CustomerVO vo);

	public List<CustomerVO> selectAll();

	public CustomerVO selectOne(CustomerVO vo);

}
