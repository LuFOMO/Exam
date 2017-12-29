package henu.exam.mapper;

import henu.exam.pojo.TbFile;
import henu.exam.pojo.TbFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFileMapper {
    int countByExample(TbFileExample example);

    int deleteByExample(TbFileExample example);

    int deleteByPrimaryKey(Integer sid);

    int insert(TbFile record);

    int insertSelective(TbFile record);

    List<TbFile> selectByExample(TbFileExample example);

    TbFile selectByPrimaryKey(Integer sid);

    int updateByExampleSelective(@Param("record") TbFile record, @Param("example") TbFileExample example);

    int updateByExample(@Param("record") TbFile record, @Param("example") TbFileExample example);

    int updateByPrimaryKeySelective(TbFile record);

    int updateByPrimaryKey(TbFile record);
}