package org.zerock.mapper;

import java.util.List;

public interface CommonMapper<VO, PK> {
	//crud 작업 한번에 하기. 편하게 할 수 있는 방법
	public int create(VO vo);
	public VO read(PK pk);
	public int update(VO vo);
	public int delete(PK pk);
	public List<VO> list(int page);

}
