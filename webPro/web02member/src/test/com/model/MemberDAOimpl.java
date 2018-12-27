package test.com.model;

import java.util.ArrayList;
import java.util.List;

public class MemberDAOimpl implements MemberDAO {

	@Override
	public int insert(MemberVO vo) {
		System.out.println("insert()....");
		System.out.println(vo.getNum());
		System.out.println(vo.getId());
		
		return 1;
	}

	@Override
	public List<MemberVO> selectAll() {
		System.out.println("selectAll()....");
		List<MemberVO> vos = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			MemberVO vo = new MemberVO();
			vo.setNum(i);
			vo.setId("id"+i);
			vos.add(vo);
		}
		return vos;
	}

	@Override
	public MemberVO selectOne(MemberVO vo) {
		System.out.println("selectOne()....");
		
		MemberVO vo2 = new MemberVO();
		vo2.setNum(vo.getNum());
		vo2.setId("id???");
		return vo2;
	}

	@Override
	public int update(MemberVO vo) {
		System.out.println("update()....");
		System.out.println(vo.getNum());
		System.out.println(vo.getId());
		
		return 0;
	}

	@Override
	public int delete(MemberVO vo) {
		System.out.println("delete()....");
		System.out.println(vo.getNum());
		
		return 1;
	}

}
