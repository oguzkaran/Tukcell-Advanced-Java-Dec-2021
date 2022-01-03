package com.turkcell.app.device.data.repository;

import static com.turkcell.app.device.data.repository.Global.PASSWORD;
import static com.turkcell.app.device.data.repository.Global.URL;
import static com.turkcell.app.device.data.repository.Global.USERNAME;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.turkcell.app.device.data.entity.Device;

public class DeviceRepository implements IDeviceRepository {		
	private static final String FIND_ALL_SQL_CMD = "select * from devices";
	private static final String FIND_BY_NAME_CONTAINS_SQL_CMD = "select * from devices where name like ?";
	
	
	private static Device getDevice(ResultSet rs) throws SQLException
	{
		return new Device(rs.getInt(1), rs.getString(2), rs.getString(3));
	}

	@Override
	public Iterable<Device> findAll() throws SQLException
	{
		List<Device> devices = new ArrayList<>();
		
		try (var conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); 
				var stmt = conn.createStatement()) {		
			var rs = stmt.executeQuery(FIND_ALL_SQL_CMD);
			
			while (rs.next()) 
				devices.add(getDevice(rs));
			
			return devices;			
		}		
	}
	
	@Override
	public Iterable<Device> findByNameContains(String str) throws SQLException
	{
		List<Device> devices = new ArrayList<>();
		
		try (var conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				var stmt = conn.prepareStatement(FIND_BY_NAME_CONTAINS_SQL_CMD)) {
			stmt.setString(1, "%" + str + "%");	
			
			var rs = stmt.executeQuery();
			
			while (rs.next()) 
				devices.add(getDevice(rs));
			
			return devices;
		}
	}
	
	///////////////////////////////////////////////////////////////////////
	@Override
	public long count() 
	{
		throw new UnsupportedOperationException("count");
	}

	@Override
	public void delete(Device entity) 
	{
		throw new UnsupportedOperationException("delete");		
	}

	@Override
	public void deleteAll()
	{
		throw new UnsupportedOperationException("deleteAll");		
	}

	@Override
	public void deleteAll(Iterable<? extends Device> entities) 
	{
		throw new UnsupportedOperationException("deleteAll");		
	}

	@Override
	public void deleteById(Integer id) 
	{
		throw new UnsupportedOperationException("deleteById");		
	}

	@Override
	public boolean existsById(Integer id)
	{
		throw new UnsupportedOperationException("existsById");
	}

	@Override
	public Iterable<Device> findAllById(Iterable<Integer> ids) 
	{
		throw new UnsupportedOperationException("findAllById");
	}

	@Override
	public Optional<Device> findById(Integer id) 
	{
		throw new UnsupportedOperationException("findById");
	}

	@Override
	public <S extends Device> S save(S entity) 
	{
		throw new UnsupportedOperationException("save");
	}

	@Override
	public <S extends Device> Iterable<S> save(Iterable<S> entities) 
	{
		throw new UnsupportedOperationException("save");
	}	
}
