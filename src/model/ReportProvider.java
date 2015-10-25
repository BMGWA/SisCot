package model;

import java.util.ArrayList;

import dao.ReportDAO;

public class ReportProvider extends Report {

	@Override
	public ArrayList<ArrayList> showProducts() {
		ReportDAO reportdao = new ReportDAO();

		ArrayList<String> listProducts = reportdao.listProductsProvider(getQuotation().getId());
		ArrayList<String> listProviders = reportdao.listProvidersProvider(getQuotation().getId());

		ArrayList<ArrayList> productsForProvider = new ArrayList<>();
		productsForProvider.add(listProducts);
		productsForProvider.add(listProviders);

		return productsForProvider;

	}

}
