package model;

import static com.google.common.net.HttpHeaders.USER_AGENT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;


public class Model {
	private static Map<String,String> data = new HashMap<String,String>();
	private static boolean activation = false;

	//Fonction de r�cup�ration des donn�es via API
	private static String sendGET() throws IOException {
		URL obj = new URL("https://coronavirusapi-france.now.sh/FranceLiveGlobalData");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			return response.toString();
		} else {
			return "API failed to collect data";
		}
	}

	private static ArrayList<JSONObject> parseData(String data){
		JSONObject itemDeces = new JSONObject();
		JSONObject itemCasConfirmes = new JSONObject();
		JSONObject itemHospitalisations = new JSONObject();
		JSONObject itemEnReanimation = new JSONObject();
		JSONObject itemGuerisons = new JSONObject();
		ArrayList<JSONObject> items = new ArrayList<>();

		Pattern patternDeces = Pattern.compile("(?:\"deces\":)(.*?)(?:,)");
		Pattern patternCasConfirmes = Pattern.compile("(?:\"casConfirmes\":)(.*?)(?:,)");
		Pattern patternHospitalisations = Pattern.compile("(?:\"hospitalises\":)(.*?)(?:,)");
		Pattern patternEnReanimation = Pattern.compile("(?:\"reanimation\":)(.*?)(?:,)");
		Pattern patternGuerisons = Pattern.compile("(?:\"gueris\":)(.*?)(?:,)");

		Matcher matcherDeces = patternDeces.matcher(data);
		Matcher matcherCasConfirmes = patternCasConfirmes.matcher(data);
		Matcher matcherHospitalisations = patternHospitalisations.matcher(data);
		Matcher matcherEnReanimation = patternEnReanimation.matcher(data);
		Matcher matcherGuerisons = patternGuerisons.matcher(data);

		if(matcherDeces.find()){
			itemDeces.put("deces",matcherDeces.group().replaceAll(",","").replaceAll("\"","").replaceAll("deces:",""));
			items.add(itemDeces); 
		}
		if(matcherCasConfirmes.find()){
			itemCasConfirmes.put("casConfirmes",matcherCasConfirmes.group().replaceAll(",","").replaceAll("\"","").replaceAll("casConfirmes:",""));
			items.add(itemCasConfirmes);
		}
		if(matcherHospitalisations.find()){
			itemHospitalisations.put("hospitalisations",matcherHospitalisations.group().replaceAll(",","").replaceAll("\"","").replaceAll("hospitalises:",""));
			items.add(itemHospitalisations);
		}
		if(matcherEnReanimation.find()){
			itemEnReanimation.put("enRea",matcherEnReanimation.group().replaceAll(",","").replaceAll("\"","").replaceAll("deces:",""));
			items.add(itemEnReanimation);
		}
		if(matcherGuerisons.find()){
			itemGuerisons.put("guerisons",matcherGuerisons.group().replaceAll(",","").replaceAll("\"","").replaceAll("gueris:",""));
			items.add(itemGuerisons);
		}

		return items;
	}

	public static void initializeMap() throws IOException{
		ArrayList<JSONObject> items = new ArrayList<>(); 
		items = parseData(sendGET());
		Pattern pattern = Pattern.compile("\\d+");       

		Matcher matcher = pattern.matcher(items.get(0).toString());
		if(matcher.find()){
			data.put("nbDeces",matcher.group());
		}
		matcher = pattern.matcher(items.get(1).toString());
		if(matcher.find()){
			data.put("nbCasConfirmes",matcher.group());
		}
		matcher = pattern.matcher(items.get(2).toString());
		if(matcher.find()){
			data.put("nbHospitalisations",matcher.group());
		}
		matcher = pattern.matcher(items.get(3).toString());
		if(matcher.find()){
			data.put("nbEnReanimation",matcher.group());
		}
		matcher = pattern.matcher(items.get(4).toString());
		if(matcher.find()){
			data.put("nbGuerisons",matcher.group());
		}
	}

	public static String getData(String dataName) {
		return data.get(dataName);
	}

	public static void setActivationFalse() {
		activation = false;
	}

	public static void setActivationTrue() {
		activation = true;
	}

	public static boolean getActivation() {
		return activation;
	}

}
