package com.example.QRcodeee;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@SpringBootApplication
public class QRcodeeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(QRcodeeeApplication.class, args);
	}
}

@RestController
@RequestMapping("/api/qrcode")
class QRcodeController {

	@GetMapping
	public ResponseEntity<byte[]> getQRCode(@RequestParam String link) {
		try {

			BitMatrix qrcode = new MultiFormatWriter().encode(link, BarcodeFormat.QR_CODE, 300, 300);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			MatrixToImageWriter.writeToStream(qrcode, "PNG", baos);


			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=qrcode.png")
					.contentType(MediaType.IMAGE_PNG)
					.body(baos.toByteArray());

		} catch (Exception e) {
			return ResponseEntity.badRequest()
					.body(("Erro ao gerar QR Code: " + e.getMessage()).getBytes());
		}
	}
}