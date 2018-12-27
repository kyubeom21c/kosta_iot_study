package test.com.model;

public interface HeroDAO {

	public int insert();

	public int delete();
	
	public int update(HeroVO vo);

	public HeroVO selectOne(HeroVO vo);

}
