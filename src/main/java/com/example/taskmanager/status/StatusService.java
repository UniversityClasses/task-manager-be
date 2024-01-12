package com.example.taskmanager.status;

import java.util.List;

public interface StatusService {

    List<StatusDTO> getAll();

    StatusDTO create(StatusDTO dto);

    StatusDTO edit(StatusDTO dto);

    StatusDTO getOne(String uuid);

    StatusDTO delete(String uuid);
}
