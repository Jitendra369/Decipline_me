package com.decipline.self.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "reading_activity")
public class ReadingActivity extends Activity {

    private String bookName;
    private int pageNumber;
    private String note;

    @Column(name = "end_read_dte")
    private boolean completedReading;

    @Column(name = "stp_read")
    private boolean stopReadingBook;

    @Column(name = "srt_read_dte")
    @CreationTimestamp
    private Date startReadingDate;

    @Column(name = "pus_read_dte")
    private Date pauseReadingDate;

    @Column(name = "pus_read")
    private Boolean pauseReadingBook;

//    @OneToOne
//    @JoinColumn(name = "book_id")
//    private Book book;


}
