package com.gilmour.client;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

/**
 * Created by alicana on 21/02/2017.
 */
public class SpotifyClient {

	private Client client;


	public SpotifyClient() {
		this.client = ClientBuilder.newClient();
	}

	public void deneme(String param, String... searchValues){

		URI uri = UriBuilder.fromUri("https://api.spotify.com/v1/search")
				.queryParam(param, searchValues)
				.queryParam("type","artist")
				.build();

		WebTarget target = client.target(uri);

		String jsonString = target.request(MediaType.APPLICATION_JSON).get(String.class);

		System.err.println(jsonString);

	}

	public static void main(String[] args) {

		SpotifyClient client = new SpotifyClient();
		client.deneme("q", "pink floyd");

	}

}
