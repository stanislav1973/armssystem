package com.example.armstest.data;

import com.example.armstest.Device;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceNameRepo extends CrudRepository<Device,Long> {
}
