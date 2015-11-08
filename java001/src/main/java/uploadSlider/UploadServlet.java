package uploadSlider;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
maxFileSize = 1024 * 1024 * 50, // 50 MB
maxRequestSize = 1024 * 1024 * 100) // 100 MB
@WebServlet("/upload.do")
public class UploadServlet extends HttpServlet {
	private static final String UPLOAD_DIR = "images/slider";
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// gets absolute path of the web application
		String applicationPath = req.getServletContext().getRealPath("/");
		// constructs path of the directory to save uploaded file
		String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;

		req.setCharacterEncoding("UTF-8");
		for (Part part : req.getParts()) {
			if (part.getName().startsWith("file")) {
				String filename = getFilename(part);
				part.write(uploadFilePath + File.separator + filename);
			}
		}

		resp.sendRedirect("admin_manageSlider.jsp");
	}

	private String getFilename(Part part) {
		String header = part.getHeader("Content-Disposition");
		String filename = header.substring(header.indexOf("filename=\"") + 10,
				header.lastIndexOf("\""));
		return filename;
	}
}
