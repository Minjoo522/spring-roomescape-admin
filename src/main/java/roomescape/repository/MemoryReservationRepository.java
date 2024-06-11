package roomescape.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Repository;
import roomescape.domain.Reservation;

@Repository
public class MemoryReservationRepository implements ReservationRepository {
    private final AtomicLong index = new AtomicLong(4);
    private final Map<Long, Reservation> reservations = new HashMap<>();

    public MemoryReservationRepository() {
        reservations.put(1L, new Reservation(1L, "브라운", LocalDate.of(2024, 6, 11), LocalTime.of(11, 0)));
        reservations.put(2L, new Reservation(2L, "리브", LocalDate.of(2024, 6, 12), LocalTime.of(12, 10)));
        reservations.put(3L, new Reservation(3L, "포케", LocalDate.of(2024, 6, 13), LocalTime.of(14, 20)));
    }

    @Override
    public List<Reservation> findAll() {
        return new ArrayList<>(reservations.values());
    }

    @Override
    public Reservation save(Reservation reservation) {
        long id = index.getAndIncrement();
        Reservation newReservation =
                new Reservation(id, reservation.getName(), reservation.getDate(), reservation.getTime());
        reservations.put(id, newReservation);
        return newReservation;
    }

    @Override
    public void delete(long id) {
        reservations.remove(id);
    }
}
