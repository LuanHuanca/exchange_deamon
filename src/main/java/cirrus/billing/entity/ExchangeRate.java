package cirrus.billing.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "eb_exchange_rate")
public class ExchangeRate extends PanacheEntityBase {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "currency_code", nullable = false)
    public String currencyCode;

    @Column(name = "official_rate", nullable = false, precision = 12 , scale = 6)
    public Double officialRate;

    @Column(name = "buy_rate", nullable = false, precision = 12 , scale = 6)
    public Double buyRate;

    @Column(name = "sell_rate", nullable = false, precision = 12 , scale = 6)
    public Double sellRate;

    @Column(name = "source", nullable = false)
    public String source;

    @Column(name = "rate_date", nullable = false)
    public java.time.LocalDate rateDate;

    @Column(name = "created_at")
    public LocalDateTime createdAt = LocalDateTime.now();
    
    public static ExchangeRate findByCurrencyAndDate(String currencyCode, LocalDate date){
        return find("currencyCode = ?1 and rateDate = ?2", currencyCode, date).firstResult();
    }
}
