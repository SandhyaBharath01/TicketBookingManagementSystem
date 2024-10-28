package com.scaler.ticketbookingmanagementsystem.Repositories;

import com.scaler.ticketbookingmanagementsystem.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatrepository extends JpaRepository<ShowSeat, Long> {
    List<ShowSeat> findAllById (Iterable<Long> ShowSeatIds);
    ShowSeat save(ShowSeat showSeat);
}
