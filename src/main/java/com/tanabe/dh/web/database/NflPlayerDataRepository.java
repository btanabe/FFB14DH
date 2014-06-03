package com.tanabe.dh.web.database;

import com.tanabe.dh.nfl.player.NflPlayerData;
import com.tanabe.dh.nfl.player.Position;
import com.tanabe.dh.nfl.team.NflTeam;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by BTanabe on 6/2/2014.
 */
@Repository
public interface NflPlayerDataRepository extends MongoRepository<NflPlayerData, String> {

//    public NflPlayerData findById(String id);
    public List<NflPlayerData> findByPlayerFirstName(String playerFirstName);
    public List<NflPlayerData> findByPlayerLastName(String playerLastName);
    public List<NflPlayerData> findByPosition(Position position);
    public List<NflPlayerData> findByCurrentTeam(NflTeam currentTeam);
}
