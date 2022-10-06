package com.swp391.ebutler.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swp391.ebutler.entities.OrderDetail;
import com.swp391.ebutler.model.dto.OrderDetailDTO;
import com.swp391.ebutler.model.mapper.OrderDetailMapper;
import com.swp391.ebutler.repositories.OrderDetailRepository;
import com.swp391.ebutler.service.OrderDetailService;

@Service
public class OrderDetailImp implements OrderDetailService {
	
	@Autowired
	OrderDetailRepository oderdetailrepo;

	@Override
	public List<OrderDetailDTO> listOrderDetailByOrderId(int id) {
		List<OrderDetail> order = oderdetailrepo.ListDetailByOrderId(id);
		List<OrderDetailDTO> dto = new ArrayList<>();
		order.forEach(v->dto.add(OrderDetailMapper.toOrderDetailDTO(v)));
		return dto;
	}

}
