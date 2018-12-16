package net.idea.ambit.knime.query;

public class AmbitConst 
{
	public static final String query_types[] = 
		{
				"bystructure_name",
				"bystructure_inchikey"
		};

	public static final String study_types[] = 
		{
				"EC_ALGAETOX_SECTION",
				"EC_BACTOX_SECTION",
				"EC_CHRONDAPHNIATOX_SECTION",
				"EC_CHRONFISHTOX_SECTION",
				"EC_DAPHNIATOX_SECTION",
				"EC_FISHTOX_SECTION",
				"EC_HONEYBEESTOX_SECTION",
				"EC_PLANTTOX_SECTION",
				"EC_SEDIMENTDWELLINGTOX_SECTION",
				"EC_SOILDWELLINGTOX_SECTION",
				"EC_SOIL_MICRO_TOX_SECTION"
		};
	
	public static final String default_ambit_db_url 
				= "https://apps.ideaconsult.net/data/";
	
}
