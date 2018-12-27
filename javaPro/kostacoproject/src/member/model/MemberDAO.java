package member.model;

import java.util.List;

public interface MemberDAO {

   public int insert(MemberVO vo);

   public int update(MemberVO vo);

   public int delete(MemberVO vo);

   public List<MemberVO> selectAll();

   public MemberVO selectOne(MemberVO vo);

   int delete();
}