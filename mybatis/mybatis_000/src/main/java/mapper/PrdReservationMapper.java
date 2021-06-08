package mapper;

import entity.PrdResRepayEntity;
import entity.ReservationSearchQueryDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PrdReservationMapper {

    List<Map<String,String>> select(@Param("query") ReservationSearchQueryDto dto);

    Integer selectCountByStatus(@Param("statusList") List<Integer> statusList);

    List<PrdResRepayEntity> selectByReserveId(Integer reserveId);
}
