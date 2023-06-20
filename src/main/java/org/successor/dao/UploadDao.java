package org.successor.dao;

import org.successor.domin.Upload;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface UploadDao {

    Upload queryById(int id);

    int addUploadRecord(Upload upload);

    Upload queryByBookId(long uploadedBook);

    Date getMaxUploadDate();

    List<Upload> queryByUploadedDate();

    List<Upload> queryByUserId(long userId);

    public int deleteUploadRow(long uploadedBook);

    public int deleteUploadRowByUser(long uploader);

    public List<Upload> searchByToday();

    public List<Upload> searchBySevenDays();

    public List<Upload> searchByThirtyDays();

}
