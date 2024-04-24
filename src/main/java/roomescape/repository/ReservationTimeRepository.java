package roomescape.repository;

import java.util.List;
import roomescape.domain.ReservationTime;

public interface ReservationTimeRepository {
    ReservationTime save(ReservationTime reservationTimeRequest);

    List<ReservationTime> findAll();

    void deleteById(Long id);
}
