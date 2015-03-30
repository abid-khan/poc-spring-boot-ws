package ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import ws.client.WeatherClient;
import ws.wsf.cdyne.com.GetCityForecastByZIPResponse;

@SpringBootApplication
public class WsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(WsApplication.class,
				args);

		WeatherClient weatherClient = ctx.getBean(WeatherClient.class);

		String zipCode = "94304";
		if (args.length > 0) {
			zipCode = args[0];
		}
		GetCityForecastByZIPResponse response = weatherClient
				.getCityForecastByZip(zipCode);
		weatherClient.printResponse(response);

	}
}
