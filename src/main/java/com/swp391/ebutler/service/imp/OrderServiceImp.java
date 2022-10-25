package com.swp391.ebutler.service.imp;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swp391.ebutler.entities.Order;
import com.swp391.ebutler.entities.OrderDetail;
import com.swp391.ebutler.entities.ProductProvider;
import com.swp391.ebutler.model.dto.OrderDTO;
import com.swp391.ebutler.model.dto.OrderDetailDTO;
import com.swp391.ebutler.model.mapper.OrderMapper;
import com.swp391.ebutler.repositories.CustomerRepository;
import com.swp391.ebutler.repositories.OrderDetailRepository;
import com.swp391.ebutler.repositories.OrderRepository;
import com.swp391.ebutler.repositories.ProductProviderRepository;
import com.swp391.ebutler.service.OrderService;

@Service
@Transactional
public class OrderServiceImp implements OrderService {
	
	Date date = new Date(System.currentTimeMillis());
	
	@Autowired
	CustomerRepository cusrepo;
	
	@Autowired
	OrderRepository repo;
	
	@Autowired
	ProductProviderRepository prepo;
	
	@Autowired
	OrderDetailRepository orderdetailrepo;
	
	
	public Order toOrder(OrderDTO orderdto) {
		Order order = new Order();
		order.setOrderId(orderdto.getOrderId());
		order.setTotalPrice(orderdto.getTotalPrice());
		order.setOrderDate(orderdto.getOrderDate());
		order.setPaymentType(orderdto.getPaymentType());
		order.setShippingStatus(orderdto.getShippingStatus());
		order.setCustomer(cusrepo.findById(orderdto.getCustomerId()).get());
		
		return order;
	}

	@Override
	public Order save(OrderDTO order) {	
		return repo.save(toOrder(order));
	}

	@Override
	public List<OrderDTO> getOrderByProvider(int id) {
		List<Integer> result = repo.listOrderByProvider(id);
		List<Order> list = new ArrayList<>();
		result.forEach(v -> list.add(repo.findById(v).get()));
		List<OrderDTO> listdto = new ArrayList<>();
		list.forEach(v-> listdto.add(OrderMapper.toOrderDTO(v)));
		return listdto;
	}

	@Override
	public List<OrderDTO> getOrderByCus(int id) {
		List<Order> result = repo.listOrderByCus(id);
		List<OrderDTO> listdto = new ArrayList<>();
		result.forEach(v-> listdto.add(OrderMapper.toOrderDTO(v)));
		return listdto;
	}

	@Override
	public List<OrderDTO> getOrderByProduct(int id) {
		List<Integer> result = repo.listOrderByProduct(id);
		List<Order> list = new ArrayList<>();
		result.forEach(v -> list.add(repo.findById(v).get()));
		List<OrderDTO> listdto = new ArrayList<>();
		list.forEach(v-> listdto.add(OrderMapper.toOrderDTO(v)));
		return listdto;
	}

	@Override
	public OrderDTO getOrderById(int id) {
		return OrderMapper.toOrderDTO(repo.findById(id).get());
	}

	@Override
	public OrderDTO changeOrderStatus(int id, int status) {
		OrderDTO dto = getOrderById(id);
		switch(status) {
		case 0: {
			dto.setShippingStatus("Cancel");
			save(dto);
			break;
		}case 1: {
			dto.setShippingStatus("New");
			save(dto);
			break;
		}case 2: {
			dto.setShippingStatus("Gathering and Packing");
			save(dto);
			break;
		}case 3: {
			dto.setShippingStatus("Packed and Delivering");
			save(dto);
			break;
		}case 4: {
			dto.setShippingStatus("Done");
			save(dto);
			break;
		}
		}
		return dto;
	}

	@Override
	public List<OrderDTO> getOrderByStatus(int status) {
		List<Order> list = new ArrayList<>();
		switch(status) {
		case 0:{
			list = repo.findByShippingStatusLike("Cancel");
			break;
		}case 1:{
			list = repo.findByShippingStatusLike("New");
			break;
		}case 2:{
			list = repo.findByShippingStatusLike("Gathering and Packing");
			break;
		}case 3:{
			list = repo.findByShippingStatusLike("Packed and Delivering");
			break;
		}case 4:{
			list = repo.findByShippingStatusLike("Done");
			break;
		}
		}
		List<OrderDTO> dto = new ArrayList<>();
		list.forEach(v-> dto.add(OrderMapper.toOrderDTO(v)));
		return dto;
	}

	@Override
	public Boolean saveNewOrder(OrderDTO orderdto) {
		List<OrderDetailDTO> listdetail = orderdto.getOrderDetailList();
		Set<Integer> setid = new HashSet<>();
		listdetail.forEach(v-> setid.add(v.getProviderId()));
		Integer count = setid.size();
		Integer[] arrayid = new Integer[setid.size()];
		setid.toArray(arrayid);
		for(int i=0; i< count; i++ ) {
			final Integer index =Integer.valueOf(i);
			List<OrderDetailDTO> singledetail = listdetail.stream().filter(a -> a.getProviderId()==arrayid[index]).collect(Collectors.toList());
			Order order = toOrderNoid(orderdto);
			order.setOrderDate(date);
			order.setShippingStatus("New");
			repo.save(order);
			
			List<OrderDetail> listOrderDetail = new ArrayList<>();
			if(singledetail != null) {
				Float total = 0f;
				for(OrderDetailDTO orderdetaildto : singledetail) {
					OrderDetail orderdetail = new OrderDetail();
					ProductProvider pProvider = prepo.findById(orderdetaildto.getProductproviderId()).get();
					orderdetail.setPProvider(pProvider);
					orderdetail.setOrder(order);
					orderdetail.setQuantity(orderdetaildto.getQuantity());
					orderdetail.setUnitPrice(orderdetaildto.getUnitPrice());
					listOrderDetail.add(orderdetail);
					
					int newquantity = pProvider.getQuantity() - orderdetaildto.getQuantity();
					pProvider.setQuantity(newquantity);
					prepo.save(pProvider);
					total = total + orderdetaildto.getUnitPrice()*orderdetaildto.getQuantity();
				}
				order.setTotalPrice(total);
				orderdetailrepo.saveAll(listOrderDetail);
			}
			order.setOrderDetailList(listOrderDetail);
		}
		return true;
	}
	
	public Order toOrderNoid (OrderDTO dto) {
		Order order = new Order();
		order.setTotalPrice(dto.getTotalPrice());
		order.setOrderDate(dto.getOrderDate());
		order.setPaymentType(dto.getPaymentType());
		order.setShippingStatus(dto.getShippingStatus());
		order.setCustomer(cusrepo.findById(dto.getCustomerId()).get());
		
		return order;
	}

}
