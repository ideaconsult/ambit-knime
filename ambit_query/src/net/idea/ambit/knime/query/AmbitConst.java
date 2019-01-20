package net.idea.ambit.knime.query;

public class AmbitConst 
{
	public static final String page = "0";
	public static final String page_size = "10";
	public static final String query_types[] = 
		{
				"bystructure_name",
				"bystructure_inchikey",
				"bystudytype"
		};
	public static final String study_categoty[] = 
		{
				"Ecotox",
				"Tox",
				"Phychem",
				"Environmental fate"
		};
	public static final String ecotox_study_types[] = 
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
	public static final String tox_study_types[] = 
		{
			"TO_ACUTE_DERMAL_SECTION",
			"TO_ACUTE_INHAL_SECTION",
			"TO_ACUTE_ORAL_SECTION", 
			"TO_CARCINOGENICITY_SECTION",
			"TO_DEVELOPMENTAL_SECTION", 
			"TO_EYE_IRRITATION_SECTION",
			"TO_GENETIC_IN_VITRO_SECTION",
			"TO_GENETIC_IN_VIVO_SECTION", 
			"TO_REPEATED_DERMAL_SECTION",
			"TO_REPEATED_INHAL_SECTION",
			"TO_REPEATED_ORAL_SECTION",
			"TO_REPRODUCTION_SECTION", 
			"TO_SENSITIZATION_SECTION",
			"TO_SKIN_IRRITATION_SECTION"

		};
	public static final String phychem_study_types[] = 
		{
			"GI_GENERAL_INFORM_SECTION",
			"PC_BOILING_SECTION",
			"PC_DISSOCIATION_SECTION", 
			"PC_GRANULOMETRY_SECTION", 
			"PC_MELTING_SECTION",
			"PC_NON_SATURATED_PH_SECTION",
			"PC_PARTITION_SECTION", 
			"PC_SOL_ORGANIC_SECTION", 
			"PC_VAPOUR_SECTION",
			"PC_WATER_SOL_SECTION"

		};
	public static final String environmental_fate_study_types[] = 
		{
			"EN_ADSORPTION_SECTION", 
			"EN_BIOACCUMULATION_SECTION", 
			"EN_BIOACCU_TERR_SECTION", 
			"EN_HENRY_LAW_SECTION", 
			"EN_STABILITY_IN_SOIL_SECTION",
			"TO_BIODEG_WATER_SCREEN_SECTION",
			"TO_BIODEG_WATER_SIM_SECTION", 
			"TO_HYDROLYSIS_SECTION\r\n", 
			"TO_PHOTOTRANS_AIR_SECTION"

		};
	
	public static final String default_ambit_db_url 
				= "https://apps.ideaconsult.net/data/";
	public static final String default_study_types_value 
				= ecotox_study_types[0];
 
}
