package model;

import java.util.ArrayList;

import dao.ReportDAO;

public class ReportManager extends Report{

	@Override
	public ArrayList<ArrayList> showProducts() {
		ReportDAO reportdao = new ReportDAO();
		
		ArrayList<String> listProducts = reportdao.listProductsManager(getQuotation().getId());
		ArrayList<String> listProviders = reportdao.listProvidersManager(getQuotation().getId());
		
		ArrayList<ArrayList> productsForProvider = new ArrayList<>();
		productsForProvider.add(listProducts);
		productsForProvider.add(listProviders);
		
		return productsForProvider;
	}

}
