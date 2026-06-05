package post.main.general.fexmode

import gregtech.api.metatileentity.multiblock.CleanroomType
import static gregtech.api.GTValues.*

//Diamond Hook diamonds -> plates
crafting.remove('hooked:diamond_hook')
crafting.shapedBuilder()
    .output(item('hooked:hook:2'))
    .matrix(
        ' PP',
        ' HP',
        'P  ')
    .key('H', item('hooked:hook:1'))
    .key('P', metaitem('plateDiamond'))
    .register()

//Vacuum Tube steel bolts -> steel rods
crafting.remove('gregtech:vacuum_tube')
crafting.shapedBuilder()
    .output(metaitem('circuit.vacuum_tube'))
    .matrix(
        '   ',
        'RGR',
        'WWW')
    .key('R', metaitem('stickSteel'))
    .key('G', metaitem('component.glass.tube'))
    .key('W', ore('wireGtSingleCopper'))
    .register()

//PBF changes
crafting.remove('gregtech:bronze_primitive_blast_furnace')
crafting.shapedBuilder()
    .output(metaitem('primitive_blast_furnace.bronze'))
    .matrix(
        'BPP',
        'WHP',
        'BPP')
    .key('B', item('gregtech:metal_casing:1')) //these are firebricks the metaitem name is fuhed or smn
    .key('P', metaitem('plateDoubleWroughtIron'))
    .key('W', ore('toolWrench'))
    .key('H', ore('blockCoke'))
    .register()

//cbt coils
//cupronickel
mods.gregtech.assembler.removeByInput(
  30,
  [metaitem('wireGtDoubleCupronickel') * 8, metaitem('foilBronze') * 8],
  [fluid('tin_alloy') * 144]
)
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('wireGtDoubleCupronickel') * 12, metaitem('foilBronze') * 12, metaitem('wireFineCopper') * 48)
    .fluidInputs(fluid('tin_alloy') * 288)
    .outputs(item('gregtech:wire_coil:0'))
    .duration(400).EUt(VA[LV])
    .buildAndRegister()

//kanthal
mods.gregtech.assembler.removeByInput(120,
    [metaitem('wireGtDoubleKanthal') * 8,
     metaitem('foilAluminium') * 8],
    [fluid('copper') * 144 * 144])
mods.gregtech.assembler.recipeBuilder()
    .inputs(ore('wireGtDoubleKanthal') * 12, metaitem('foilAluminium') * 12, ore('wireFineZinc') * 48)
    .fluidInputs(fluid('molybdenum') * 576)
    .outputs(item('gregtech:wire_coil:1'))
    .duration(600).EUt(VA[MV])
    .buildAndRegister()

//nichrome
mods.gregtech.assembler.removeByInput(480,
    [metaitem('wireGtDoubleNichrome') * 8,
     metaitem('foilStainlessSteel') * 8],
    [fluid('aluminium') * 144 * 144])
mods.gregtech.assembler.recipeBuilder()
    .inputs(ore('wireGtDoubleNichrome') * 16, metaitem('foilStainlessSteel') * 16, ore('wireFinePlatinum') * 64)
    .fluidInputs(fluid('ultimet') * 576)
    .outputs(item('gregtech:wire_coil:2'))
    .duration(1000).EUt(VA[HV])
    .buildAndRegister()

//rtm
mods.gregtech.assembler.removeByInput(1920,
    [metaitem('wireGtDoubleRtmAlloy') * 8,
     metaitem('foilVanadiumSteel') * 8],
    [fluid('nichrome') * 144 * 144])
mods.gregtech.assembler.recipeBuilder()
    .inputs(ore('wireGtDoubleRtmAlloy') * 24, metaitem('foilVanadiumSteel') * 24, ore('stickLongTitanium') * 12)
    .fluidInputs(fluid('cobalt') * 1152)
    .outputs(item('gregtech:wire_coil:3'))
    .duration(1400).EUt(VA[EV])
    .buildAndRegister()

//hss-g
mods.gregtech.assembler.removeByInput(7680,
    [metaitem('wireGtDoubleHssg') * 8,
     metaitem('foilTungstenCarbide') * 8],
    [fluid('tungsten') * 144 * 144])
mods.gregtech.assembler.recipeBuilder()
    .inputs(ore('frameGtHssg'),
        ore('wireGtDoubleHssg') * 48,
        metaitem('plateTungstenCarbide') * 24,
        ore('stickLongVanadiumGallium') * 16,
        ore('circuitLuv') * 2)
    .fluidInputs(fluid('molten.hsse') * 1728)
    .outputs(item('gregtech:wire_coil:4'))
    .duration(2000).EUt(VA[IV])
    .buildAndRegister()

//voltage coil changes
//remove all voltage coil recipes lv+
for (var tier: ['lv', 'mv', 'hv', 'ev', 'iv', 'luv', 'zpm', 'uv']) {
    mods.gregtech.assembler.removeByOutput([metaitem("voltage_coil.${tier}")], null)
}

void addVoltageCoilAss (Collection<ItemStack> output,
                        Collection<IIngredient> input,
                        IIngredient fluid, Integer length,
                        Integer energy) {
    mods.gregtech.assembler.recipeBuilder()
        .inputs(input)
        .circuitMeta(1)
        .fluidInputs(fluid)
        .outputs(output)
        .duration(length).EUt(energy)
        .buildAndRegister()
}

//lv coil
addVoltageCoilAss([metaitem('voltage_coil.lv')],
    [metaitem('stickIronMagnetic'),
     metaitem('wireFineSteel') * 32],
    fluid('lead') * 288, 200, 30)
//mv coil
addVoltageCoilAss([metaitem('voltage_coil.mv')],
    [metaitem('stickSteelMagnetic') * 2,
     metaitem('wireFineAluminium') * 64],
    fluid('steel') * 576, 320, 120)
//hv coil
addVoltageCoilAss([metaitem('voltage_coil.hv')],
    [metaitem('stickNeodymiumMagnetic') * 2,
     metaitem('wireFineStainlessSteel') * 64,
     metaitem('wireFineStainlessSteel') * 64],
    fluid('antimony') * 576, 400, 480)
//ev coil
addVoltageCoilAss([metaitem('voltage_coil.ev')],
    [metaitem('stickNeodymiumMagnetic') * 4,
     metaitem('wireGtSinglePlatinum') * 64,
     metaitem('boltTitanium') * 64],
    fluid('tantalum') * 864, 600, 1920)
//iv coil
addVoltageCoilAss([metaitem('voltage_coil.iv')],
    [metaitem('stickLongSamariumMagnetic') * 6,
     metaitem('wireFineIridium') * 64,
     metaitem('wireFineIridium') * 64,
     metaitem('foilIridium') * 64,
     metaitem('foilIridium') * 64,],
    fluid('bismuth') * 1728, 1000, 7680)

//luv coil
mods.gregtech.assembly_line.recipeBuilder()
    .inputs(metaitem('blockSamariumMagnetic'),
        metaitem('stickLongSamariumMagnetic') * 12,
        metaitem('ringOsmiridium') * 64,
        metaitem('gearSmallOsmiridium') * 24,
        metaitem('plateOsmiridium') * 16)
    .fluidInputs(fluid('berkelium') * 1296, fluid('liquid_helium') * 4000)
    .outputs(metaitem('voltage_coil.luv'))
    .scannerResearch(b -> b.researchStack(metaitem('voltage_coil.iv')))
    .duration(1800).EUt(VA[LuV])
    .buildAndRegister()

//zpm coil
mods.gregtech.assembly_line.recipeBuilder()
    .inputs(item('nomilabs:magnetron') * 2,
        metaitem('stickLongSamariumMagnetic') * 24,
        metaitem('plateDoubleEuropium') * 16,
        metaitem('foilEuropium') * 64,
        metaitem('wireGtDoubleEuropium') * 64,
        metaitem('springEuropium') * 12)
    .fluidInputs(fluid('californium') * 2592, fluid('liquid_helium') * 16000)
    .outputs(metaitem('voltage_coil.zpm'))
    .stationResearch(b -> b.researchStack(metaitem('voltage_coil.luv')).CWUt(8))
    .duration(3200).EUt(VA[ZPM])
    .buildAndRegister()

//uv coil
mods.gregtech.assembly_line.recipeBuilder()
    .inputs(item('nomilabs:magnetron') * 8,
        metaitem('stickLongSamariumMagnetic') * 64,
        metaitem('plateDenseTritanium') * 6,
        metaitem('ringTritanium') * 64,
        metaitem('gearSmallTritanium') * 48,
        metaitem('foilTritanium') * 64,
        metaitem('foilTritanium') * 64,
        metaitem('wireGtDoubleTritanium') * 64,
        metaitem('wireGtQuadrupleTritanium') * 24,
        metaitem('springTritanium') * 16)
    .fluidInputs(fluid('plasma.argon') * 10368, fluid('liquid_helium') * 80000)
    .outputs(metaitem('voltage_coil.uv'))
    .stationResearch(b -> b.researchStack(metaitem('voltage_coil.zpm')).CWUt(64))
    .duration(5600).EUt(VA[UV])
    .buildAndRegister()

//remove all energy hatch recipes
for (var hatchTier: ['lv', 'mv']) {
    crafting.remove("gregtech:energy_hatch.${hatchTier}")
    mods.gregtech.assembler.removeByOutput([metaitem("energy_hatch.input.$hatchTier")], null)
}

for (var hatchTier: ['hv', 'ev', 'iv']) {
    mods.gregtech.assembler.removeByOutput([metaitem("energy_hatch.input.${hatchTier}")], null)
}

for (var hatchTier: ['luv', 'zpm', 'uv', 'uhv']) {
    mods.gregtech.assembly_line.removeByOutput([metaitem("energy_hatch.input.${hatchTier}")], null)
}

//lv energy hatch
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('hull.lv'), metaitem('cableGtSingleTin') * 2, metaitem('voltage_coil.lv'))
    .fluidInputs(fluid('sodium_potassium') * 250)
    .outputs(metaitem('energy_hatch.input.lv'))
    .duration(200).EUt(VA[LV])
    .buildAndRegister()

//mv energy hatch
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('hull.mv'), metaitem('cableGtSingleCopper') * 2,
        metaitem('voltage_coil.mv'), metaitem('electric.pump.mv'),
        metaitem('plate.ultra_low_power_integrated_circuit') * 2)
    .fluidInputs(fluid('sodium_potassium') * 500)
    .outputs(metaitem('energy_hatch.input.mv'))
    .duration(400).EUt(VA[MV])
    .buildAndRegister()

//hv energy hatch
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('hull.hv'), metaitem('cableGtSingleGold') * 4,
        metaitem('voltage_coil.hv'), metaitem('electric.pump.hv'),
        metaitem('plate.low_power_integrated_circuit') * 4)
    .fluidInputs(fluid('sodium_potassium') * 1000)
    .outputs(metaitem('energy_hatch.input.hv'))
    .duration(600).EUt(VA[HV])
    .buildAndRegister()

//ev energy hatch
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('hull.ev'), metaitem('cableGtSingleAluminium') * 8,
        metaitem('voltage_coil.ev'), metaitem('electric.pump.ev') * 2,
        metaitem('plate.power_integrated_circuit') * 6, ore('circuitEv'))
    .fluidInputs(fluid('sodium_potassium') * 2000)
    .outputs(metaitem('energy_hatch.input.ev'))
    .duration(900).EUt(VA[EV])
    .buildAndRegister()

//iv energy hatch
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('charger.iv'), metaitem('cableGtSingleTungsten') * 16,
        metaitem('voltage_coil.iv'), metaitem('fluid.regulator.iv') * 2,
        metaitem('plate.high_power_integrated_circuit') * 12, ore('circuitIv'))
    .fluidInputs(fluid('sodium_potassium') * 4000)
    .outputs(metaitem('energy_hatch.input.iv'))
    .duration(1400).EUt(VA[IV])
    .buildAndRegister()

//luv energy hatch
mods.gregtech.assembly_line.recipeBuilder()
    .inputs(metaitem('charger.luv'), metaitem('cableGtSingleNiobiumTitanium') * 16,
        metaitem('voltage_coil.luv'), metaitem('fluid.regulator.luv') * 2,
        metaitem('wafer.high_power_integrated_circuit') * 12, metaitem('plate.ultra_high_power_integrated_circuit') * 8,
        ore('circuitLuv') * 2)
    .fluidInputs(fluid('sodium_potassium') * 8000, fluid('soldering_alloy') * 1440,
        fluid('indium_tin_barium_titanium_cuprate') * 720)
    .outputs(metaitem('energy_hatch.input.luv'))
    .scannerResearch(b -> b.researchStack(metaitem('energy_hatch.input.iv')))
    .duration(2400).EUt(VA[LuV])
    .buildAndRegister()

//zpm energy hatch
mods.gregtech.assembly_line.recipeBuilder()
    .inputs(metaitem('charger.zpm'), metaitem('cableGtSingleVanadiumGallium') * 16,
        metaitem('voltage_coil.zpm') * 2, metaitem('fluid.regulator.zpm') * 2,
        metaitem('wafer.high_power_integrated_circuit') * 20, metaitem('plate.ultra_high_power_integrated_circuit') * 16,
        ore('circuitZpm') * 4)
    .fluidInputs(fluid('sodium_potassium') * 16000, fluid('soldering_alloy') * 2880,
        fluid('uranium_rhodium_dinaquadide') * 1440)
    .outputs(metaitem('energy_hatch.input.zpm'))
    //this adds research but it doesnt work with the custom CWU and eu parameters
    .stationResearch(b -> b.researchStack(metaitem('energy_hatch.input.luv')).CWUt(16).EUt(VA[LuV]))
    .duration(3600).EUt(VA[ZPM])
    .buildAndRegister()

//uv energy hatch
mods.gregtech.assembly_line.recipeBuilder()
    .inputs(metaitem('charger.uv'), metaitem('cableGtSingleYttriumBariumCuprate') * 16,
        metaitem('voltage_coil.uv') * 2, metaitem('fluid.regulator.uv') * 4,
        metaitem('wafer.high_power_integrated_circuit') * 32, metaitem('plate.ultra_high_power_integrated_circuit') * 32,
        ore('circuitUv') * 4)
    .fluidInputs(fluid('sodium_potassium') * 32000, fluid('soldering_alloy') * 5760,
        fluid('enriched_naquadah_trinium_europium_duranide') * 2880)
    .outputs(metaitem('energy_hatch.input.uv'))
    .stationResearch(b -> b.researchStack(metaitem('energy_hatch.input.zpm')).CWUt(64).EUt(VA[ZPM]))
    .duration(6000).EUt(VA[UV])
    .buildAndRegister()

//uhv energy hatch
mods.gregtech.assembly_line.recipeBuilder()
    .inputs(metaitem('substation_hatch.input_64a.uv'),
        metaitem('cableGtSingleEuropium') * 16, item('gregtech:fusion_casing:4'),
        metaitem('wafer.high_power_integrated_circuit') * 64, metaitem('plate.ultra_high_power_integrated_circuit') * 64,
        ore('plateDoubleAwakenedDraconium') * 16, ore('circuitUhv') * 16)
    .fluidInputs(fluid('sodium_potassium') * 64000, fluid('soldering_alloy') * 11520,
        fluid('ruthenium_trinium_americium_neutronate') * 5760)
    .outputs(metaitem('energy_hatch.input.uhv'))
    .stationResearch(b -> b.researchStack(metaitem('energy_hatch.input.uv')).CWUt(256).EUt(VA[UHV]))
    .duration(6400).EUt(VA[UHV])
    .buildAndRegister()

//pyro oven changes
crafting.remove('nomiceu:pyrolyse_oven')
crafting.shapedBuilder()
    .output(metaitem('pyrolyse_oven'))
    .matrix(
        'ECW',
        'CHC',
        'EPL')
    .key('E', metaitem('electric.piston.lv'))
    .key('C', ore('circuitLv'))
    .key('W', ore('wireGtHexSteel'))
    .key('H', metaitem('hull.ulv'))
    .key('P', metaitem('electric.pump.lv'))
    .key('L', ore('pipeHugeFluidLead'))
    .register()

//pbf recipes changes
mods.gregtech.primitive_blast_furnace.removeByOutput([metaitem('ingotSteel'), metaitem('dustTinyDarkAsh') * 2], null)
mods.gregtech.primitive_blast_furnace.removeByOutput([metaitem('ingotSteel'), metaitem('dustTinyAsh')], null)
mods.gregtech.primitive_blast_furnace.removeByOutput([metaitem('blockSteel'), metaitem('dustDarkAsh') * 2], null)
mods.gregtech.primitive_blast_furnace.removeByOutput([metaitem('blockSteel'), metaitem('dustAsh')], null)
mods.gregtech.primitive_blast_furnace.recipeBuilder()
    .inputs(item('minecraft:iron_ingot'), metaitem('gemCoke') * 2)
    .outputs(metaitem('ingotSteel'))
    .duration(2400).EUt(1)
    .buildAndRegister()

//ebf steel changes
mods.gregtech.electric_blast_furnace.removeByInput(120, [item('minecraft:iron_ingot')], [fluid('oxygen') * 200 * 200])
mods.gregtech.electric_blast_furnace.removeByInput(120,
    [metaitem('dustIron'), metaitem('circuit.integrated').withNbt(['Configuration': 2])], [fluid('oxygen') * 200 * 200])
mods.gregtech.electric_blast_furnace.removeByInput(120, [metaitem('ingotWroughtIron')], [fluid('oxygen') * 200 * 200])
mods.gregtech.electric_blast_furnace.removeByInput(120,
    [metaitem('dustWroughtIron'), metaitem('circuit.integrated').withNbt(['Configuration': 2])], [fluid('oxygen') * 200 * 200])
mods.gregtech.electric_blast_furnace.removeByInput(1920, [metaitem('dustIron') * 4, metaitem('dustCarbon')], null)
mods.gregtech.electric_blast_furnace.removeByInput(1920, [metaitem('dustWroughtIron') * 4, metaitem('dustCarbon')], null)
mods.gregtech.electric_blast_furnace.recipeBuilder()
    .inputs(ore('ingotIron'))
    .fluidInputs(fluid('oxygen') * 360)
    .outputs(metaitem('ingotSteel'))
    .property('temperature', 1800)
    .duration(120).EUt(VA[HV])
    .buildAndRegister()

//silicon boule buff
mods.gregtech.electric_blast_furnace.removeByInput(120,
    [metaitem('dustSilicon') * 32, metaitem('dustSmallGalliumArsenide'),
     metaitem('circuit.integrated').withNbt(['Configuration': 2])],
    null
)

mods.gregtech.electric_blast_furnace.recipeBuilder()
    .inputs(metaitem('dustSilicon') * 64, metaitem('dustGalliumArsenide'))
    .circuitMeta(3)
    .fluidInputs(fluid('nitrogen') * 48000)
    .outputs(metaitem('boule.silicon'))
    .duration(47000).EUt(VA[MV])
    .property('temperature', 1784)
    .buildAndRegister()

//basic wafer cutting changes
mods.gregtech.cutter.removeByOutput([metaitem('wafer.silicon') * 16], null)
mods.gregtech.cutter.recipeBuilder()
    .inputs(metaitem('boule.silicon'))
    .fluidInputs(fluid('lubricant') * 200)
    .outputs(metaitem('wafer.silicon') * 16)
    .duration(1200).EUt(64)
    .buildAndRegister()

//lbb changes
crafting.remove('gregtech:large_bronze_boiler')
crafting.shapedBuilder()
    .output(metaitem('large_boiler.bronze'))
    .matrix(
        'WCW',
        'CHC',
        'WCW')
    .key('W', metaitem('cableGtOctalAnnealedCopper'))
    .key('C', ore('circuitLv'))
    .key('H', item('gregtech:turbine_casing:0')) //bronze gearbox
    .register()

//maintenance hatch changes
crafting.remove('gregtech:maintenance_hatch')
mods.gregtech.assembler.removeByInput(
    30,
    [metaitem('hull.lv'), metaitem('circuit.integrated').withNbt(['Configuration': 8])], null)
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('hull.lv'), metaitem('plateIron') * 2, metaitem('plateLead') * 2, metaitem ('ringRubber'))
    .circuitMeta(8)
    .outputs(metaitem('maintenance_hatch'))
    .duration(200).EUt(VA[LV])
    .buildAndRegister()

//lv circuit assembler
crafting.remove('gregtech:gregtech.machine.circuit_assembler.lv')
crafting.shapedBuilder()
    .output(metaitem('circuit_assembler.lv'))
    .matrix(
        'APE',
        'CHC',
        'MFM')
    .key('A', metaitem('robot.arm.lv'))
    .key('P', metaitem('pipeNormalFluidLead'))
    .key('E', metaitem('emitter.lv'))
    .key('C', metaitem('conveyor.module.lv'))
    .key('H', metaitem('hull.lv'))
    .key('M', ore('circuitMv'))
    .key('F', metaitem('field.generator.lv'))
    .register()

//mv circuit assembler
crafting.remove('gregtech:gregtech.machine.circuit_assembler.mv')
crafting.shapedBuilder()
    .output(metaitem('circuit_assembler.mv'))
    .matrix(
        'APE',
        'CHC',
        'MFM')
    .key('A', metaitem('robot.arm.mv'))
    .key('P', metaitem('pipeNormalFluidVanadiumSteel'))
    .key('E', metaitem('emitter.mv'))
    .key('C', metaitem('conveyor.module.mv'))
    .key('H', metaitem('hull.mv'))
    .key('M', ore('circuitHv'))
    .key('F', metaitem('field.generator.mv'))
    .register()

/*hv assembler, buffed and moved to ass
crafting.remove('gregtech:gregtech.machine.assembler.hv')
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem(''), metaitem('') * 2, metaitem(''))
    .fluidInputs(fluid('') * 144)
    .outputs(metaitem(''))
    .duration(200).EUt(VA[LV])
    .buildAndRegister()
*/

//stainless steel changes
mods.gregtech.electric_blast_furnace.removeByOutput([metaitem('ingotStainlessSteel')], null)
mods.gregtech.electric_blast_furnace.recipeBuilder()
    .inputs(metaitem('dustStainlessSteel'))
    .circuitMeta(1)
    .outputs(metaitem('ingotStainlessSteel'))
    .duration(9000).EUt(VA[HV])
    .property('temperature', 1700)
    .buildAndRegister()

mods.gregtech.electric_blast_furnace.recipeBuilder()
    .inputs(metaitem('dustStainlessSteel'))
    .circuitMeta(2)
    .fluidInputs(fluid('helium') * 500)
    .outputs(metaitem('ingotStainlessSteel'))
    .duration(3000).EUt(VA[EV])
    .property('temperature', 1700)
    .buildAndRegister()

//kanthal changes
mods.gregtech.electric_blast_furnace.removeByOutput([metaitem('ingotHotKanthal')], null)
mods.gregtech.electric_blast_furnace.recipeBuilder()
    .inputs(metaitem('dustKanthal'))
    .circuitMeta(1)
    .outputs(metaitem('ingotHotKanthal'))
    .duration(3600).EUt(VA[HV])
    .property('temperature', 1800)
    .buildAndRegister()

mods.gregtech.electric_blast_furnace.recipeBuilder()
    .inputs(metaitem('dustKanthal'))
    .circuitMeta(2)
    .fluidInputs(fluid('nitrogen') * 1000)
    .outputs(metaitem('ingotHotKanthal'))
    .duration(2412).EUt(VA[HV])
    .property('temperature', 1800)
    .buildAndRegister()

//titanium loop no longer closed, 2 -> 4 magnesium :problem:, also buffed duration for ebf
mods.gregtech.electric_blast_furnace.removeByInput(480, [metaitem('dustMagnesium') * 2],
    [fluid('titanium_tetrachloride') * 1000 * 1000])
mods.gregtech.electric_blast_furnace.recipeBuilder()
    .inputs(metaitem('dustMagnesium') * 4)
    .fluidInputs(fluid('titanium_tetrachloride') * 1100)
    .outputs(metaitem('ingotHotTitanium'), metaitem('dustMagnesiumChloride') * 6)
    .duration(4000).EUt(VA[HV])
    .property('temperature', 2141)
    .buildAndRegister()

//abs recipes completely removed rn cuz of laziness and also i dont like them
mods.gregtech.alloy_blast_smelter.removeByOutput(null, [fluid('molten.tungsten_steel')])
mods.gregtech.alloy_blast_smelter.removeByOutput(null, [fluid('molten.tungsten_carbide')])

//theres prob a better way to do this
for(var tungType: ['n', 'nSteel', 'nCarbide']) {
    mods.gregtech.electric_blast_furnace.removeByOutput([metaitem("ingotHotTungste${tungType}")], null)
}

//new tungsten/-alloy recipes
def tungstenTypes = [
    "Tungsten": [
        smeltTime: 8200,
        smeltTimeGas: 2740,
        temperature: 3600,
    ],
    "TungstenSteel": [
        smeltTime: 10400,
        smeltTimeGas: 3460,
        temperature: 4000,
    ],
    "TungstenCarbide": [
        smeltTime: 7800,
        smeltTimeGas: 2600,
        temperature: 3058,
    ],
]

//without gas
tungstenTypes.forEach { String type, Map ebfParams ->
    mods.gregtech.electric_blast_furnace.recipeBuilder()
        .inputs(metaitem("dust${type}"))
        .circuitMeta(1)
        .outputs(metaitem("ingotHot${type}"))
        .duration(ebfParams.smeltTime).EUt(VA[IV])
        .property('temperature', ebfParams.temperature)
        .buildAndRegister()
}

//with gas
tungstenTypes.forEach { String type, Map ebfParams ->
    mods.gregtech.electric_blast_furnace.recipeBuilder()
        .inputs(metaitem("dust${type}"))
        .circuitMeta(2)
        .fluidInputs(fluid('argon') * 100)
        .outputs(metaitem("ingotHot${type}"))
        .duration(ebfParams.smeltTimeGas).EUt(VA[LuV])
        .property('temperature', ebfParams.temperature)
        .buildAndRegister()
}



//advanced inscriber changes
crafting.remove('ae2stuff:recipe1')
crafting.shapedBuilder()
    .output(item('ae2stuff:inscriber'))
    .matrix(
        'PCP',
        'EIE',
        'PCP')
    .key('P', metaitem('plateStainlessSteel'))
    .key('C', metaitem('conveyor.module.hv'))
    .key('E', item('appliedenergistics2:material:24'))
    .key('I', item('appliedenergistics2:inscriber'))
    .register()

//pcc changes
crafting.remove('nae2:item/upgrade/gregtech_circuit')
mods.gregtech.assembler.recipeBuilder()
    .inputs(item('appliedenergistics2:material:53'), ore('circuitEv') * 2,
        metaitem('circuit.integrated').withNbt(['Configuration' : 0]) * 16)
    .fluidInputs(fluid('plastic') * 576)
    .outputs(item('nae2:upgrade:2'))
    .duration(300).EUt(VA[HV])
    .buildAndRegister()

//mm stuff changes
//basic mining laser
crafting.shapedBuilder()
    .output(item('nomilabs:t1laser'))
    .matrix(
        ' F ',
        'PBP',
        'PCP')
    .key('F', ore('blockCrystalFlux'))
    .key('P', metaitem('plateDoubleSteel'))
    .key('B', metaitem('energy_crystal').withNbt(['Charge' : 6400000]))
    .key('C', ore('circuitHv'))
    .register()

//water -> liquid ice for silicon and kanthal in chembath
for (var kanthalSilicon: ['Kanthal', 'Silicon']) {
    mods.gregtech.chemical_bath.removeByOutput([metaitem("ingot${kanthalSilicon}")], null)
    mods.gregtech.chemical_bath.recipeBuilder()
        .inputs(metaitem("ingotHot${kanthalSilicon}"))
        .fluidInputs(fluid('ice') * 300)
        .outputs(metaitem("ingot${kanthalSilicon}"))
        .duration(800).EUt(VA[MV])
        .buildAndRegister()
}

//change t2 cir theme to not work with smd also some slight buffs
//removals
// Integrated Processor * 1
mods.gregtech.circuit_assembler.removeByInput(60,
    [metaitem('circuit_board.plastic'),
     metaitem('plate.central_processing_unit'),
     metaitem('component.resistor') * 4,
     metaitem('component.capacitor') * 4,
     metaitem('component.transistor') * 4,
     metaitem('wireFineRedAlloy') * 4],
    [fluid('soldering_alloy') * 72 * 72])
// Integrated Processor * 1
mods.gregtech.circuit_assembler.removeByInput(60,
    [metaitem('circuit_board.plastic'),
     metaitem('plate.central_processing_unit'),
     metaitem('component.resistor') * 4,
     metaitem('component.capacitor') * 4,
     metaitem('component.transistor') * 4,
     metaitem('wireFineRedAlloy') * 4],
    [fluid('tin') * 144 * 144])

//these are ez cuz no soc recipe
mods.gregtech.circuit_assembler.removeByOutput([metaitem('circuit.assembly')], null)
mods.gregtech.circuit_assembler.removeByOutput([metaitem('circuit.workstation')], null)
mods.gregtech.circuit_assembler.removeByOutput([metaitem('circuit.mainframe')], null)

//changes
//integrated processor
mods.gregtech.circuit_assembler.recipeBuilder()
    .inputs(metaitem('circuit_board.plastic'),
        metaitem('plate.central_processing_unit') * 2,
        metaitem('component.resistor') * 4,
        metaitem('component.capacitor') * 4,
        metaitem('component.transistor') * 4,
        metaitem('wireFineRedAlloy') * 8)
    .fluidInputs(fluid('soldering_alloy') * 72)
    .outputs(metaitem('circuit.processor'))
    .duration(300).EUt(VHA[MV])
    .buildAndRegister()

//processor assembly
mods.gregtech.circuit_assembler.recipeBuilder()
    .inputs(metaitem('circuit_board.plastic'),
        metaitem('circuit.processor') * 2,
        metaitem('component.inductor') * 8,
        metaitem('component.capacitor') * 12,
        metaitem('plate.random_access_memory') * 8,
        metaitem('wireFineRedAlloy') * 16)
    .fluidInputs(fluid('soldering_alloy') * 144)
    .outputs(metaitem('circuit.assembly'))
    .duration(600).EUt(90)
    .buildAndRegister()

//workstation
mods.gregtech.circuit_assembler.recipeBuilder()
    .inputs(metaitem('circuit_board.plastic'),
        metaitem('circuit.assembly') * 2,
        metaitem('component.diode') * 8,
        metaitem('plate.random_access_memory') * 8,
        metaitem('wireFineElectrum') * 32,
        metaitem('nomilabs:boltVibrantAlloy') * 32)
    .fluidInputs(fluid('soldering_alloy') * 144)
    .outputs(metaitem('circuit.workstation'))
    .cleanroom(CleanroomType.CLEANROOM)
    .duration(600).EUt(VA[MV])
    .buildAndRegister()

//mainframe
mods.gregtech.circuit_assembler.recipeBuilder()
    .inputs(metaitem('frameAluminium') * 4,
        metaitem('circuit.workstation') * 4,
        metaitem('component.inductor') * 24,
        metaitem('component.capacitor') * 32,
        metaitem('plate.random_access_memory') * 16,
        metaitem('wireGtSingleAnnealedCopper') * 16)
    .fluidInputs(fluid('soldering_alloy') * 288)
    .outputs(metaitem('circuit.mainframe'))
    .cleanroom(CleanroomType.CLEANROOM)
    .duration(1200).EUt(VA[HV])
    .buildAndRegister()

//pvc plastic board nerfed to return only 1, 4 -> 8 copper foils, duration 25s -> 30s (now matches 1:1 ratio)
mods.gregtech.chemical_reactor.removeByInput(10,
    [metaitem('platePolyvinylChloride'),
     metaitem('foilCopper') * 4],
    [fluid('sulfuric_acid') * 250])
mods.gregtech.chemical_reactor.recipeBuilder()
    .inputs(metaitem('platePolyvinylChloride'), metaitem('foilCopper') * 8)
    .fluidInputs(fluid('sulfuric_acid') * 250)
    .outputs(metaitem('board.plastic'))
    .duration(600).EUt(10)
    .buildAndRegister()

//epoxy board 500mb sulfuric acid -> 2b, 30s at lv -> 30s at hv, buffed and moved to lcr
mods.gregtech.chemical_reactor.removeByOutput([metaitem('board.epoxy')], null)
mods.gregtech.large_chemical_reactor.recipeBuilder()
    .inputs(metaitem('plateEpoxy') * 2, metaitem('foilGold') * 20)
    .fluidInputs(fluid('sulfuric_acid') * 2000)
    .outputs(metaitem('board.epoxy'))
    .duration(600).EUt(VA[HV])
    .buildAndRegister()

//prob useless to have a map here but i wanted to test
def boardFluids = [
    { int amount -> fluid('iron_iii_chloride') * amount },
    { int amount -> fluid('sodium_persulfate') * (amount * 2) },
]

mods.gregtech.chemical_reactor.removeByOutput([metaitem('circuit_board.advanced')], null)
boardFluids.forEach { boardFluid ->
    mods.gregtech.large_chemical_reactor.recipeBuilder()
        .inputs(metaitem('board.epoxy'), metaitem('foilElectrum') * 12, metaitem('cableGtSingleAnnealedCopper') * 6)
        .fluidInputs(boardFluid(500))
        .outputs(metaitem('circuit_board.advanced'))
        .duration(700).EUt(VA[HV])
        .buildAndRegister()
}

//fiber epoxy rework
mods.thermalexpansion.compactor.removeByOutput(metaitem('plateReinforcedEpoxyResin'))
mods.gregtech.fluid_solidifier.removeByOutput([metaitem('plateReinforcedEpoxyResin')], null)
mods.gregtech.cutter.removeByOutput([metaitem('plateReinforcedEpoxyResin')], null)
mods.gregtech.extruder.removeByOutput([metaitem('plateReinforcedEpoxyResin')], null)
mods.gregtech.chemical_bath.removeByOutput([metaitem('plateReinforcedEpoxyResin')], null)
mods.gregtech.large_chemical_reactor.recipeBuilder()
    .inputs(metaitem('carbon.fibers') * 6)
    .fluidInputs(fluid('epoxy') * 288)
    .circuitMeta(25)
    .fluidOutputs(fluid('reinforced_epoxy_resin') * 144)
    .duration(240).EUt(VA[EV])
    .buildAndRegister()

mods.gregtech.autoclave.recipeBuilder()
    .inputs(metaitem('board.epoxy'))
    .fluidInputs(fluid('reinforced_epoxy_resin') * 144)
    .outputs(metaitem('plateReinforcedEpoxyResin'))
    .duration(500).EUt(VA[HV])
    .buildAndRegister()

//t4 boards buff
mods.gregtech.chemical_reactor.removeByOutput([metaitem('board.fiber_reinforced')], null)
mods.gregtech.large_chemical_reactor.recipeBuilder()
    .inputs(metaitem('plateReinforcedEpoxyResin'), metaitem('foilManganese') * 24)
    .fluidInputs(fluid('sulfuric_acid') * 1000)
    .outputs(metaitem('board.fiber_reinforced'))
    .duration(600).EUt(VHA[EV])
    .buildAndRegister()

mods.gregtech.chemical_reactor.removeByOutput([metaitem('circuit_board.extreme')], null)
boardFluids.forEach { boardFluid ->
    mods.gregtech.large_chemical_reactor.recipeBuilder()
        .inputs(metaitem('board.fiber_reinforced'), metaitem('foilAluminium') * 16, metaitem('cableGtSingleCobalt') * 8)
        .fluidInputs(boardFluid(1000))
        .outputs(metaitem('circuit_board.extreme'))
        .duration(500).EUt(VA[EV])
        .buildAndRegister()
}

//distillation tower buffed and moved to ass
crafting.remove('gregtech:distillation_tower')
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('distillery.hv'),
        item('gregtech:wire_coil:2') * 4,
        metaitem('pipeHugeFluidStainlessSteel') * 6,
        metaitem('electric.pump.hv') * 8,
        ore('circuitEv') * 12)
    .fluidInputs(fluid('lubricant') * 16000)
    .outputs(metaitem('distillation_tower'))
    .duration(1200).EUt(VA[HV])
    .buildAndRegister()

//NaK "realism"
mods.gregtech.chemical_reactor.removeByOutput(null, [fluid('sodium_potassium')])
mods.gregtech.chemical_reactor.recipeBuilder()
    .inputs(metaitem('dustPotassium') * 4, metaitem('dustSodium'))
    .fluidOutputs(fluid('sodium_potassium') * 720)
    .duration(800).EUt(VA[LV])
    .buildAndRegister()

//me out hatch
mods.gregtech.assembler.removeByOutput([metaitem('me_export_fluid_hatch')], null)
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('fluid_hatch.export.ev'), item('appliedenergistics2:drive'),
        metaitem('super_tank.ev') * 10, item('appliedenergistics2:part:221') * 4)
    .outputs(metaitem('me_export_fluid_hatch'))
    .duration(400).EUt(VA[HV])
    .buildAndRegister()

//me in hatch
mods.gregtech.assembler.removeByOutput([metaitem('me_import_fluid_hatch')], null)
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('fluid_hatch.import.ev'), item('appliedenergistics2:fluid_interface') * 4,
        metaitem('electric.pump.ev') * 4)
    .outputs(metaitem('me_import_fluid_hatch'))
    .duration(400).EUt(VA[HV])
    .buildAndRegister()

//me out bus
mods.gregtech.assembler.removeByOutput([metaitem('me_export_item_bus')], null)
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('item_bus.export.ev'), item('appliedenergistics2:drive'),
        metaitem('super_chest.ev') * 10, item('appliedenergistics2:part:220') * 4)
    .outputs(metaitem('me_export_item_bus'))
    .duration(400).EUt(VA[HV])
    .buildAndRegister()

//me in bus
mods.gregtech.assembler.removeByOutput([metaitem('me_import_item_bus')], null)
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('item_bus.import.ev'), item('appliedenergistics2:interface') * 4,
        metaitem('conveyor.module.ev') * 4)
    .outputs(metaitem('me_import_item_bus'))
    .duration(400).EUt(VA[HV])
    .buildAndRegister()

//stocking bus and hatch
for (var stockingType: ['fluid_hatch', 'item_bus']) {
mods.gregtech.assembler.removeByOutput([metaitem("me_stocking_${stockingType}")], null)
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem("${stockingType}.import.iv"), metaitem("me_import_${stockingType}"),
        item('nae2:exposer') * 4, item('appliedenergistics2:io_port') * 4,
        metaitem('field.generator.iv') * 4, item('appliedenergistics2:material', 30) * 16)
    .fluidInputs(fluid('nether_star') * 2592)
    .outputs(metaitem("me_stocking_${stockingType}"))
    .duration(800).EUt(7920)
    .buildAndRegister()
}

//lcr, buffed and moved to ass
crafting.remove('gregtech:large_chemical_reactor')
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('chemical_reactor.hv') * 4, metaitem('fluid.regulator.hv') * 2,
        metaitem('pipeNonupleFluidPolytetrafluoroethylene') * 4,
        item('gregtech:meta_item_1', 711).withNbt(['GT.PartStats': ['Material': 'gregtech:stainless_steel']]),
        ore('circuitEv') * 4)
    .outputs(metaitem('large_chemical_reactor'))
    .duration(700).EUt(VA[HV])
    .buildAndRegister()

//comp buffs hv-iv
void makeMotor (String recipeName, ItemStack output,
                Collection <IIngredient> input, IIngredient fluid,
                Integer length, Integer energy) {

    crafting.remove(recipeName)
    mods.gregtech.assembler.removeByOutput([output], null)
    mods.gregtech.assembler.recipeBuilder()
        .inputs(input)
        .outputs(output)
        .fluidInputs(fluid)
        .duration(length).EUt(energy)
        .buildAndRegister()
}
//hv motor
makeMotor('gregtech:electric_motor_hv', metaitem('electric.motor.hv'),
    [metaitem('cableGtDoubleSilver') * 4, metaitem('stickStainlessSteel') * 4,
     metaitem('stickSteelMagnetic') * 2, metaitem('boltIronMagnetic') * 16,
     metaitem('wireFineStainlessSteel') * 64, metaitem('wireGtDoubleElectrum') * 8],
    fluid('lubricant') * 288, 200, 64)
//ev motor
makeMotor('gregtech:electric_motor_ev', metaitem('electric.motor.ev'),
    [metaitem('cableGtQuadrupleAluminium') * 6, metaitem('stickTitanium') * 6,
     metaitem('ringTitanium') * 16, metaitem('stickNeodymiumMagnetic') * 4,
     metaitem('nuggetSteelMagnetic') * 64, metaitem('wireFinePalladium') * 64,
     metaitem('wireFinePalladium') * 32], fluid('lubricant') * 432,
    300, 256)
//iv motor
makeMotor('gregtech:electric_motor_iv', metaitem('electric.motor.iv'),
    [metaitem('cableGtQuadrupleTungsten') * 8, metaitem('stickTungstenSteel') * 10,
     metaitem('ringChrome') * 24, metaitem('gearRhodium') * 4,
     metaitem('stickLongSamariumMagnetic') * 4, metaitem('wireFineTungstenSteel') * 64,
     metaitem('wireFineTungstenSteel') * 64, metaitem('wireGtDoubleGraphene') * 12],
    fluid('lubricant') * 576, 400, 1024)

//luv+ motor removals
for (var tier: ['luv', 'zpm', 'uv']) {
    mods.gregtech.assembly_line.removeByOutput([metaitem("electric.motor.${tier}")], null)
}

//luv motor
mods.gregtech.assembly_line.recipeBuilder()
    .inputs(metaitem('stickLongSamariumMagnetic') * 8, metaitem('stickLongHsss') * 12,
        metaitem('gearHsss') * 8, metaitem('nuggetTrinium') * 32,
        metaitem('gearSmallTungstenCarbide') * 16, metaitem('foilRuridit') * 64,
        metaitem('wireFineRuridit') * 64)
    .fluidInputs(fluid('molten.titanium_tungsten_carbide') * 864, fluid('soldering_alloy') * 1152, fluid('lubricant') * 1000)
    .outputs(metaitem('electric.motor.luv'))
    .scannerResearch(b -> b.researchStack(metaitem('electric.motor.iv')))
    .duration(800).EUt(VA[LuV])
    .buildAndRegister()

//zpm motor
mods.gregtech.assembly_line.recipeBuilder()
    .inputs(metaitem('stickLongSamariumMagnetic') * 12, metaitem('stickLongOsmiridium') * 20,
        metaitem('plateOsmiridium') * 32, metaitem('nuggetNaquadahEnriched') * 48,
        metaitem('gearDuranium') * 12, metaitem('wireGtDoubleEuropium') * 64,
        metaitem('foilNaquadahAlloy') * 64)
    .fluidInputs(fluid('molten.enderium') * 1152, fluid('soldering_alloy') * 2304, fluid('lubricant') * 6000)
    .outputs(metaitem('electric.motor.zpm'))
    .scannerResearch(b -> b.researchStack(metaitem('electric.motor.luv')))
    .duration(1000).EUt(VA[ZPM])
    .buildAndRegister()

//uv motor
mods.gregtech.assembly_line.recipeBuilder()
    .inputs(metaitem('stickLongSamariumMagnetic') * 24, metaitem('ingotLutetium') * 64,
        metaitem('ingotCalifornium') * 64, metaitem('nuggetTrinaquadalloy') * 64,
        metaitem('wireFineNaquadria') * 64, metaitem('wireGtSingleUraniumRhodiumDinaquadide') * 64,
        item('nuclearcraft:part', 2) * 64)
    .fluidInputs(fluid('awakened_draconium') * 1152, fluid('neutronium') * 432,
        fluid('soldering_alloy') * 6912, fluid('lubricant') * 30000)
    .outputs(metaitem('electric.motor.uv'))
    .stationResearch(b -> b.researchStack(metaitem('electric.motor.zpm')).CWUt(32).EUt(VA[LuV]))
    .duration(1200).EUt(VA[UV])
    .buildAndRegister()

