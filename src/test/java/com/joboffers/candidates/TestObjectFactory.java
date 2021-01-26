package com.joboffers.candidates;

import com.joboffers.candidates.domain.entity.CandidateEntity;
import com.joboffers.candidates.domain.entity.EducationalInformationEntity;
import com.joboffers.candidates.domain.entity.ProfessionalInformationEntity;
import com.joboffers.candidates.domain.entity.TechnologyEntity;
import com.joboffers.candidates.service.model.Candidate;
import com.joboffers.candidates.service.model.EducationalInformation;
import com.joboffers.candidates.service.model.Gender;
import com.joboffers.candidates.service.model.ProfessionalInformation;
import com.joboffers.candidates.service.model.Technology;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public final class TestObjectFactory {

    public static Candidate createEmptyCandidate() {
        return Candidate.builder().build();
    }

    public static Candidate createCandidate(
            final List<EducationalInformation> educationalInformationList,
            final List<ProfessionalInformation> professionalInformationList) {

        return Candidate.builder()
                .name("Patricia")
                .birthday(LocalDate.of(1990, 10, 10))
                .gender(Gender.WOMAN)
                .email("patricia@candidate.com")
                .address("Valencia 124")
                .linkedIn("linkedin.com/patricia")
                .phoneNumber("6223344")
                .educationalInformationList(educationalInformationList)
                .professionalInformationList(professionalInformationList)
                .build();
    }

    public static CandidateEntity createEmptyCandidateEntity() {
        return CandidateEntity.builder()
                .id(UUID.randomUUID())
                .build();
    }

    public static CandidateEntity createCandidateEntity(
            final List<EducationalInformationEntity> educationalInformationEntityList,
            final List<ProfessionalInformationEntity> professionalInformationEntityList) {

        return CandidateEntity.builder()
                .name("Patricia")
                .birthday(LocalDate.of(1990, 10, 10))
                .gender(Gender.WOMAN)
                .email("patricia@candidate.com")
                .address("Valencia 124")
                .linkedIn("linkedin.com/patricia")
                .phoneNumber("6223344")
                .educationalInformationList(educationalInformationEntityList)
                .professionalInformationList(professionalInformationEntityList)
                .build();
    }

    public static EducationalInformation createEducationalInformation(
            final LocalDate startDate,
            final LocalDate endDate,
            final List<Technology> technologyList) {

        return EducationalInformation.builder()
                .name("University")
                .description("Informatics Engineering")
                .startDate(startDate)
                .endDate(endDate)
                .course("Java programming")
                .place("UPC")
                .technologyList(technologyList)
                .build();
    }

    public static EducationalInformationEntity createEducationalInformationEntity(
            final LocalDate startDate,
            final LocalDate endDate,
            final List<TechnologyEntity> technologyList) {

        return EducationalInformationEntity.builder()
                .description("Informatics Engineering")
                .startDate(startDate)
                .endDate(endDate)
                .course("Java programming")
                .place("UPC")
                .technologyList(technologyList)
                .build();
    }

    public static ProfessionalInformation createProfessionalInformation(
            final LocalDate startDate,
            final LocalDate endDate,
            final List<Technology> technologyList) {

        return ProfessionalInformation.builder()
                .name("First company job")
                .description("Informatics Engineering at a consultant company")
                .startDate(startDate)
                .endDate(endDate)
                .notes("Working as a Java programmer for 10 years")
                .technologyList(technologyList)
                .build();
    }
}
