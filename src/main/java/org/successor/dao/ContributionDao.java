package org.successor.dao;

import org.successor.domin.Contribution;
import org.springframework.stereotype.Repository;


@Repository
public interface ContributionDao {

    Contribution queryByValue(int value);
}
