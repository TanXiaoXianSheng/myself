package mapper;

import entity.ReservationSearchQueryDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PrdReservationMapper {

    List<Map<String,String>> select(@Param("query") ReservationSearchQueryDto dto);
}
