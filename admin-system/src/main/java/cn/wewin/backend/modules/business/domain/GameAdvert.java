package cn.wewin.backend.modules.business.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

/**
* @author JULIE
* @date 2019-10-10
*/
@Entity
@Data
@Table(name="game_advert")
public class GameAdvert implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "gamesId")
    private Integer gamesid;
}