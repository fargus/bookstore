package DAO;

public class DaoFactory {
	
	private AuthorsDAO authorsDAO = new AuthorsDAO();
    private BooksDAO booksDAO = new BooksDAO();
    private ClientsDAO clientsDAO = new ClientsDAO();
    private SellhistoryDAO sellhistoryDAO = new SellhistoryDAO();

    private static DaoFactory instance = null;

    public static synchronized DaoFactory getInstance() {
        if (instance == null) {
            instance = new DaoFactory();
        }

        return instance;
    }

	public AuthorsDAO getAuthorsDAO() {
		return authorsDAO;
	}

	public BooksDAO getBooksDAO() {
		return booksDAO;
	}

	public ClientsDAO getClientsDAO() {
		return clientsDAO;
	}

	public SellhistoryDAO getSellhistoryDAO() {
		return sellhistoryDAO;
	}
    
    
}
