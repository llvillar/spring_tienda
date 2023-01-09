package com.llvillar.springboot.app1.dao.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Order;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import com.llvillar.springboot.app1.dao.DetallePedidoDAO;
import com.llvillar.springboot.app1.dao.PedidosDAO;
import com.llvillar.springboot.app1.model.Cliente;
import com.llvillar.springboot.app1.model.DetallePedido;
import com.llvillar.springboot.app1.model.Pedido;

@Repository
public class DetallePedidoDAOImpl extends JdbcDaoSupport implements DetallePedidoDAO{


    @Autowired
    DataSource dataSource;
    
    @PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}

   

   
    @Override
    public void insert(Pedido pedido, DetallePedido detallePedido) {
        String query = "insert into Detalle_Pedido (cantidad," + 
                                            " precio," + 
                                            " total," + 
                                            " codigo_pedido," + 
                                            " codigo_producto)" + 
                                            " values (?, ?, ?, ?, ?)";
        Object[] params = {
            detallePedido.getCantidad(),
            detallePedido.getProducto().getPrecio(),
            detallePedido.getProducto().getPrecio()*detallePedido.getCantidad(),
            pedido.getCodigo(),
            detallePedido.getProducto().getCodigo()
        };

        final int[] types = {
            Types.INTEGER,
            Types.DECIMAL,
            Types.DECIMAL,
            Types.INTEGER,
            Types.INTEGER
        };
        
        int update = getJdbcTemplate().update(query, params, types);        
    }
}